package cu.edu.cujae.questionservice.constants;

public class WebResourceKeyConstants {
    public static final String FEEDBACK_API = "/api/feedback";
    public static final String PISTA_API = "/api/pista";
    public static final String PREGUNTA_API = "/api/pregunta";
    public static final String PROFILE_RESPUESTA_PREGUNTA_API = "/api/profile-respuesta-pregunta";
    public static final String RESPUESTA_API = "/api/respuesta";
    public static final String TIPO_PISTA_API = "/api/tipo-pista";
    public static final String TIPO_PREGUNTA_API = "/api/tipo-pregunta";
    public static final String BONIFICACION_PREGUNTA_TIEMPO_API = "/api/bonificacion-pregunta-tiempo";
    public static final String PISTA_PREGUNTA_API = "/api/pista-pregunta";
    public static final String PREGUNTA_RESPUESTA_API = "/api/pregunta-respuesta";

    public interface PistaPreguntaUrls{
        String PISTA_PREGUNTA_SAVE = "/save";
    }

    public interface PreguntaRespuestaUrls{
        String PREGUNTA_RESPUESTA_SAVE = "/save";
    }

    public interface BonificacionPreguntaTiempoUrls {
        String BONIFICACION_PREGUNTA_TIEMPO_GET_BY_ID = "/id";
        String BONIFICACION_PREGUNTA_TIEMPO_DELETE_BY_ID = "/delete/id";
        String BONIFICACION_PREGUNTA_TIEMPO_SAVE = "/save";
        String BONIFICACION_PREGUNTA_TIEMPO_UPDATE = "/update";
    }

    public interface PistaUrls {
        String PISTA_GET_BY_ID = "/id";
        String PISTA_DELETE_BY_ID = "/delete/id";
        String PISTA_GET_BY_TYPE = "/type";
        String PISTA_SAVE = "/save";
        String PISTA_UPDATE = "/update";
    }

    public interface PreguntaUrls {
        String PREGUNTA_GET_BY_ID = "/id";
        String PREGUNTA_DELETE_BY_ID = "/delete/id";
        String PREGUNTA_GET_BY_TYPE = "/type";
        String PREGUNTA_SAVE = "/save";
        String PREGUNTA_UPDATE = "/update";
    }

    public interface ProfileRespuestaPreguntaUrls {
        String PROFILE_RESPUESTA_PREGUNTA_GET_BY_ID = "/id";
        String PROFILE_RESPUESTA_PREGUNTA_DELETE_BY_ID = "/delete/id";
        String PROFILE_RESPUESTA_PREGUNTA_SAVE = "/save";
        String PROFILE_RESPUESTA_PREGUNTA_UPDATE = "/update";
    }

    public interface RespuestaUrls {
        String RESPUESTA_GET_BY_ID = "/id";
        String RESPUESTA_DELETE_BY_ID = "/delete/id";
        String RESPUESTA_SAVE = "/save";
        String RESPUESTA_UPDATE = "/update";
    }

    public interface TipoPistaUrls {
        String TIPO_PISTA_GET_BY_ID = "/id";
        String TIPO_PISTA_DELETE_BY_ID = "/delete/id";
        String TIPO_PISTA_SAVE = "/save";
        String TIPO_PISTA_UPDATE = "/update";
    }

    public interface TipoPreguntaUrls {
        String TIPO_PREGUNTA_GET_BY_ID = "/id";
        String TIPO_PREGUNTA_DELETE_BY_ID = "/delete/id";
        String TIPO_PREGUNTA_SAVE = "/save";
        String TIPO_PREGUNTA_UPDATE = "/update";
    }

    public interface FeedbackUrls{
        String GET_FEEDBACK_BY_ID = "/id";
        String DELETE_FEEDBACK_BY_ID = "/delete/id";
        String SAVE_FEEDBACK = "/save";
        String UPDATE_FEEDBACK = "/update";
    }

}
