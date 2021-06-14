package cu.edu.cujae.userservice.constants;

public class MicroserviceConstantService {

    public static final String BASE_API_LOGIN = "/api";
    public static final String BASE_API_SCHOOLAR = "/api";


    public interface LoginMicroservice{
        String BASE = "login-service";
        String LOGIN = "/login";

    }

    public interface SchoolarMicroservice{
        String BASE = "schoolar-management-service";
        String SAVE_STUDENT="/estudiante/save";
        String GET_FACULTY_NAME="/facultad/name";
    }

}
