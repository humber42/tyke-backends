package cu.edu.cujae.loginservice.constants;

/*This class contains custom error messages for various exception*/
public class ErrorMessageConstants {

    public interface ForgetPassword{
        String DEVELOPER_MESSAGE ="Password didn't match with the original one";
        String MESSAGE = "Incorrect password.Forgot password";
    }

    public interface IncorrectPasswordAttempts{
        String DEVELOPER_MESSAGE = "User is blocked with status 'B'";
        String MESSAGE = "User is blocked. Please contact your system administrator";
    }

    public interface InvalidAdminStatus{
        String DEVELOPER_MESSAGE_FOR_BLOCKED="The user has status 'B'";
        String DEVELOPER_MESSAGE_FOR_INACTIVE="The user has status 'N'";
        String MESSAGE_FOR_BLOCKED ="The user is in blocked state";
        String MESSAGE_FOR_INACTIVE ="The user is in inactive state";
    }

    public interface InvalidUsername{
        String DEVELOPER_MESSAGE = "User entity returnes null";
        String MESSAGE = "User with given username doestn't exist";
    }
}
