package cu.edu.cujae.userservice.api;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import cu.edu.cujae.userservice.domain.LoginClass;

import cu.edu.cujae.userservice.domain.User;
import cu.edu.cujae.userservice.service.UserService;
import io.swagger.annotations.Api;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import static cu.edu.cujae.userservice.constants.WebResourceKeyConstants.*;


@RestController
@RequestMapping(value= BASE_API+USER_BASE)
@Api(value = "This is user controller")
public class UserRestController {

    @Autowired
    private UserService userService;
    @Autowired
    Mapper mapper;

  
    @PostMapping(value = SAVE)
    public int saveUser(@RequestBody UserRequest request){
        return userService.save(request);
    }

    
    @PostMapping(value = UPDATE)
    public int updateUser(@RequestBody UserResponse userRequest){
        return userService.update(userRequest);
    }

    
    @GetMapping(value = FETCH_USER_BY_USERNAME)
    public UserResponse fetchUserByUsername(@PathVariable("username") String username){
        return mapper.map(userService.findByUsername(username),UserResponse.class);
    }

    @GetMapping(value = GET_ALL_PROFESSORS)
    public List<UserResponse> getUserProfessors(){
        return userService.getAllUserWithRolProfesors()
                .stream()
                .map(user->mapper.map(user,UserResponse.class))
                .collect(Collectors.toList());
    }

    @PostMapping(value = CHANGE_PASSWORD)
    public int changePassword(@RequestBody UserResponse response){
        return userService.changePassword(mapper.map(response, User.class));
    }

    @GetMapping(value=FETCH_USER_BY_FULLNAME)
    public UserResponse fetchByFullname(@PathVariable("fullname") String fullname){
        return mapper.map(userService.findByFullname(fullname),UserResponse.class);
    }

    
    @GetMapping(value = FETCH_ALL_USERS)
    public List<UserResponse> fetchAllUsers(){
        List<UserResponse> responses = new LinkedList<>();
        userService.findAll().forEach(
                user-> responses.add(mapper.map(user,UserResponse.class))
        );
        return responses;
    }

  
    @GetMapping(FETCH_BY_ID)
    public UserResponse fetchById(@PathVariable("id") long id){
        return userService.findById(id).map(user->mapper.map(user, UserResponse.class)).get();
    }

    @PostMapping(DELETE_USER)
    public int deleteUserById(@RequestBody UserResponse userResponse){
        return userService.delete(userResponse.getId());
    }

    @PostMapping(REGISTER)
    public String registerUser(@RequestBody UserRegister userRegister){
        int resultado = userService.register(userRegister);
        String token = "";
        if(resultado==1&&userService.saveStudentInsideSchool(userRegister)){
            LoginClass loginClass = new LoginClass();
            loginClass.setUserCredential(userRegister.getUsername());
            loginClass.setPassword(userRegister.getPassword());
            token = userService.login(loginClass);
        }
        return token;
    }

    @GetMapping("/sayHello/{name}")
    @HystrixCommand(fallbackMethod = "fallBackHello",commandProperties = {
            @HystrixProperty(
                    name="execution.isolation.thread.timeoutInMilliseconds",value="5000"
            )
    })
    public String sayHello(@PathVariable("name")String name){
        if(name.equalsIgnoreCase("hello")) throw new RuntimeException();
        return "success METHOD";
    }

    public String fallBackHello(String name){
        return "fallback hello "+name;
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello World!";
    }

}
