package cu.edu.cujae.scholarManagement.constants;

public class MicroserviceConstantsResource {

    public static final String BASE_API_USER = "/api/user";

    public interface UserMicroserviceConstants{
        String BASE ="user-service";
        String FETCH_USER_BY_ID = "/fetch-user-by-id/{id}";
    }
}
