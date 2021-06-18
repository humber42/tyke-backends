package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.PreguntaDto;

import java.util.List;
import java.util.Optional;

public interface PreguntaService {

    List<PreguntaDto> getAllPreguntas();
    List<PreguntaDto> getAllPreguntasByTipo(String tipo);
    Optional<PreguntaDto> findOnePregunta(long id);
    int savePregunta(PreguntaDto dto);
    PreguntaDto updatePregunta(PreguntaDto dto);
    PreguntaDto deletePregunta(long id);

}
