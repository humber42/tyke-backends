package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.RespuestaDto;

import java.util.List;
import java.util.Optional;

public interface RespuestaService {

    List<RespuestaDto> getAllRespuesta();
    Optional<RespuestaDto> getOne(long id);
    RespuestaDto save(RespuestaDto dto);
    RespuestaDto update(RespuestaDto dto);
    RespuestaDto delete(long id);

}
