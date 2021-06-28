package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaRequestWithAllThings;
import cu.edu.cujae.tykestrategy.dto.EstrategiaDto;

import java.util.List;
import java.util.Optional;

public interface EstrategiaService {
    Optional<EstrategiaDto> getEstrategiaById(long id);
    List<EstrategiaDto> findAllEstrategia();
    int saveEstrategia(EstrategiaDto dto);
    Optional<EstrategiaDto> updateEstrategiaDto(EstrategiaDto dto);
    void deleteEstrategiaById(long id);
    void deleteEstrategia(EstrategiaDto dto);
    int saveEstrategiaComplete(EstrategiaRequestWithAllThings estrategiaRequest);
}
