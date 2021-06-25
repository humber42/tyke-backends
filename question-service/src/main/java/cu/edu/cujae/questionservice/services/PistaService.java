package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.PistaDto;

import java.util.List;
import java.util.Optional;

public interface PistaService {

    List<PistaDto> getAllPistas();
   // List<PistaDto> getPistaByTipo(String tipo);
    Optional<PistaDto> findOnePista(long id);
    int savePista(PistaDto dto);
    PistaDto updatePista(PistaDto dto);
    PistaDto deletePistaById(long id);

}
