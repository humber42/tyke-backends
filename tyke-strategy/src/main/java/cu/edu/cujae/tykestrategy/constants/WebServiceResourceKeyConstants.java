package cu.edu.cujae.tykestrategy.constants;

public class WebServiceResourceKeyConstants {

    public static final String ESTRATEGIA_GRUPO_API ="/api/v1/estrategia-grupo";
    public static final String ESTRATEGIA_API = "/api/v1/estrategia";
    public static final String ESTRATEGIA_TEMA_API = "/api/v1/estrategia-tema";
    public static final String INSIGNIA_API = "/api/v1/insignia";
    public static final String JUGADOR_DESAFIO_API="/api/v1/jugador-desafio";
    public static final String JUGADOR_ESTRATEGIA_API = "/api/v1/jugador-estrategia";
    public static final String JUGADOR_INSIGNIA_API = "/api/v1/jugador-insignia";
    public static final String JUGADOR_REGALO_API = "/api/v1/jugador-regalo";
    public static final String OTORGAMIENTO_API ="/api/v1/otorgamiento";
    public static final String PUNTUACION_API = "/api/v1/puntuacion";
    public static final String REGALO_API = "/api/v1/regalo";
    public static final String ROL_PROFESIONAL_API = "/api/v1/rol-profesional";
    public static final String TIPO_REGALO_API = "/api/v1/tipo-regalo";

    public interface Endpoints{
        String GET_ALL = "/all";
        String GET_BY_ID = "/id";
        String UPDATE = "/update";
        String SAVE = "/save";
        String DELETE = "/delete";
        String DELETE_BY_ID ="/delete/id";
        String SAVE_STRATEGY_SPECIAL_ENDPOINT="/save/all";
    }

}
