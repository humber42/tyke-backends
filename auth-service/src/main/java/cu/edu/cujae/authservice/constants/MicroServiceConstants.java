package cu.edu.cujae.authservice.constants;

public class MicroServiceConstants {

    public static final String LOGIN_MICROSERVICE = "/login-service/api/login";
	public static final String REGISTER_MICROSERVICE = "/user-service/api/user/register";
	public static final String FETCH_USER_USERNAME = "/user-service/api/user/fetch-user/{username}";
	public static final String FETCH_ALL_FACULTIES ="/schoolar-management-service/api/facultad";

    public static final String USER_MICROSERVICE = "user-service";
    public static final String BASE_API = "/api/user";

    public interface UserMicroServiceConstants {
        String FETCH_USER_USERNAME = "/fetch-user/{username}";
    }
}
