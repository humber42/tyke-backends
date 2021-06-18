package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.TipoPreguntaDto;

import java.util.List;
import java.util.Optional;

public interface TipoPreguntaService {

    List<TipoPreguntaDto> getAllTipoPregunta();
    Optional<TipoPreguntaDto> getOneTipoPregunta(long id);
    TipoPreguntaDto save(TipoPreguntaDto dto);
    TipoPreguntaDto update(TipoPreguntaDto dto);
    TipoPreguntaDto delete(long id);
}
