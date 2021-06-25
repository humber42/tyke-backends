package cu.edu.cujae.questionservice.repository;


import cu.edu.cujae.questionservice.dto.*;
import org.springframework.stereotype.Repository;


public interface JdbcRepository {

    int saveFeedback(FeedbackDto dto);
    int saveBonificacion(BonificacionPreguntaTiempoDto dto);
    int savePista(PistaDto dto);
    int savePregunta(PreguntaDto dto);
    int saveProfileRespuesta(ProfileRespuestaPreguntaDto dto);
    int saveRespuesta(RespuestaDto dto);
    int saveTipoPista(TipoPistaDto dto);
    int saveTipoPregunta(TipoPreguntaDto dto);

}
