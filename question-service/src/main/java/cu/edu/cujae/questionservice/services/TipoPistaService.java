package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.TipoPistaDto;

import java.util.List;
import java.util.Optional;

public interface TipoPistaService {

    List<TipoPistaDto> getAllTipoPista();
    Optional<TipoPistaDto> getOneTipoPista(long id);
    TipoPistaDto save(TipoPistaDto dto);
    TipoPistaDto update(TipoPistaDto dto);
    TipoPistaDto delete(long id);
    TipoPistaDto getByName(String name);
}
