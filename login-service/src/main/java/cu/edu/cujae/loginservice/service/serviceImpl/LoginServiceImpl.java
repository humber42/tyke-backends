package cu.edu.cujae.loginservice.service.serviceImpl;


import cu.edu.cujae.loginservice.constants.ErrorMessageConstants;
import cu.edu.cujae.loginservice.constants.PatternConstants;
import cu.edu.cujae.loginservice.exceptions.UnauthorisedException;
import cu.edu.cujae.loginservice.feignInterface.UserInterface;
import cu.edu.cujae.loginservice.jwt.JwtTokenProvider;
import cu.edu.cujae.loginservice.requestDTO.LoginRequest;
import cu.edu.cujae.loginservice.requestDTO.UserRequest;
import cu.edu.cujae.loginservice.responseDTO.UserResponse;
import cu.edu.cujae.loginservice.service.LoginService;
import cu.edu.cujae.loginservice.utils.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.function.Consumer;



@Service
@Transactional("transactionManager")
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    JwtTokenProvider provider;

    @Autowired
    private UserInterface userInterface;

    @Override
    public String login(LoginRequest requestLogin, HttpServletRequest request){
        LOGGER.info("Login in process started");
        long startTime = DateUtils.getTimeInMillisecondsFromLocalDate();
        UserResponse user = fetchUserDetails(requestLogin);
        validateUsername(user);
       validateUserStatus(user);
        validatePassword(requestLogin,user);
        String jwtToken = provider.createToken(user,request);

        LOGGER.info("LOGIN PROCESS COMPLETED IN ::: " + (DateUtils.getTimeInMillisecondsFromLocalDate() - startTime)
                + " ms");
        return jwtToken;
    }

    private UserResponse fetchUserDetails(LoginRequest request){
        return userInterface.searchByUsername(request.getUserCredential());
    }

    private void validateUsername(UserResponse user){
        if(user.getUsername().isEmpty())
            throw new UnauthorisedException(ErrorMessageConstants.InvalidUsername.MESSAGE, ErrorMessageConstants.InvalidUsername.DEVELOPER_MESSAGE);
        LOGGER.info("::: Username Validated");
    }

//    private Consumer<UserResponse> validateUserUsername = (user)->{
//        if (Objects.isNull(user))
//            throw new UnauthorisedException(ErrorMessageConstants.InvalidUsername.MESSAGE, ErrorMessageConstants.InvalidUsername.DEVELOPER_MESSAGE);
//        LOGGER.info("::: Username Validated");
//    };

//    private Consumer<UserResponse> validateUserStatus = (user)->{
//        switch (user.getStatus()){
//            case "B":
//                throw new UnauthorisedException(ErrorMessageConstants.InvalidAdminStatus.MESSAGE_FOR_BLOCKED,
//                        ErrorMessageConstants.InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_BLOCKED);
//            case "N":
//                throw new UnauthorisedException(ErrorMessageConstants.InvalidAdminStatus.MESSAGE_FOR_INACTIVE,
//                        ErrorMessageConstants.InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_INACTIVE);
//        }
//        LOGGER.info("::: ADMIN STATUS VALIDATED :::");
//    };

    private void validateUserStatus(UserResponse user){
        switch (user.getStatus()){
            case "B":
                throw new UnauthorisedException(ErrorMessageConstants.InvalidAdminStatus.MESSAGE_FOR_BLOCKED,
                        ErrorMessageConstants.InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_BLOCKED);
            case "N":
                throw new UnauthorisedException(ErrorMessageConstants.InvalidAdminStatus.MESSAGE_FOR_INACTIVE,
                        ErrorMessageConstants.InvalidAdminStatus.DEVELOPER_MESSAGE_FOR_INACTIVE);
        }
        LOGGER.info("::: ADMIN STATUS VALIDATED :::");
    }



    private void validatePassword(LoginRequest request, UserResponse user){
        LOGGER.info("::: PASSWORD VALIDATION :::");

        if (BCrypt.checkpw(
                request.getPassword(),
                user.getPassword()
        )){
            user.setLoginAttempt(0);
            userInterface.updateUser(user);
        }else{
            user.setLoginAttempt(user.getLoginAttempt()+1);
            if(user.getLoginAttempt()>=3){
                user.setStatus("B");
                userInterface.updateUser(user);

                LOGGER.debug("USER IS BLOCKED DUE TO MULTIPLE WRONG ATTEMPTS...");
                throw new UnauthorisedException(ErrorMessageConstants.ForgetPassword.MESSAGE,
                        ErrorMessageConstants.ForgetPassword.DEVELOPER_MESSAGE);
            }

            LOGGER.debug("INCORRECT PASSWORD...");
            throw new UnauthorisedException(ErrorMessageConstants.ForgetPassword.MESSAGE,
                    ErrorMessageConstants.ForgetPassword.DEVELOPER_MESSAGE);
        }

        LOGGER.info("::: User Password validated");
    }




}
