package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.EstrategiaTemaDto;

import java.util.List;
import java.util.Optional;

public interface EstrategiaTemaService {
    Optional<EstrategiaTemaDto> getEstrategiaTemaById(long id);
    List<EstrategiaTemaDto> findAllEstrategiaTema();
    int saveEstrategiaTema(EstrategiaTemaDto dto);
    Optional<EstrategiaTemaDto> updateEstrategiaDto(EstrategiaTemaDto dto);
    void deleteEstrategiaTemaById(long id);
    void deleteEstrategiaTema(EstrategiaTemaDto dto);
}
