package cu.edu.cujae.tykestrategy.constants;

public class MicroservicesConstants {

    public static final String BASE_USER_API ="/api/user";

    public static final String BASE_SCHOOLAR= "/api";

    public interface CarreraMicroserviceConstants{
        String BASE = "schoolar-management-service";
        String FETCH_CARRERA_BY_ID = "/carrera/id";
    }

    public interface UserMicroserviceConstants{
        String BASE = "user-service";
        String FECTH_USER_BY_ID = "/fetch-user-by-id/{id}";
    }

    public interface TemaMicroserviceConstants{
        String FETCH_TEMA_BY_ID ="/tema/id";
    }

    public interface GrupoMicroserviceConstants{
        String FETCH_GRUPO_BY_ID ="/grupo/id";
    }

}
