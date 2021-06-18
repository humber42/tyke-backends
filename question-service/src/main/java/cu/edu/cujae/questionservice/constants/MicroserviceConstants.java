package cu.edu.cujae.questionservice.constants;

public class MicroserviceConstants {
    public static final String BASE_API_USER = "/api/user";
    public static final String BASE_API_ASIGNATURA = "/api/asignatura";

    public interface UserMicroserviceConstants{
        String BASE ="user-service";
        String FETCH_USER_BY_ID = "/fetch-user/{username}";
    }

    public interface SchoolarManagementConstants{
        String BASE = "schoolar-management-service";
        String FETCH_BY_NAME = "/name/{name}";
    }
}
