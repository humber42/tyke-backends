package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.PreguntaRespuestaDto;

import java.util.Optional;

public interface PreguntaRespuestaService {

    int savePreguntaRespuesta(PreguntaRespuestaDto dto);
}
