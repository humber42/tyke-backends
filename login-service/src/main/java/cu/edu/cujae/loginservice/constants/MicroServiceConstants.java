package cu.edu.cujae.loginservice.constants;

public class MicroServiceConstants {

    public static final String BASE_API ="/api/user";

    public interface UserMicroserviceConstants{
        String BASE ="user-service";
        String SEARCH_USER = "/search";
        String UPDATE_USER = "/update";
        String FETCH_BY_USERNAME ="/fetch-user/{username}";
    }
}
