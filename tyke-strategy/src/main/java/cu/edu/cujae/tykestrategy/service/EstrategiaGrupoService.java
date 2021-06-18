package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.EstrategiaGrupoDto;

import java.util.List;
import java.util.Optional;

public interface EstrategiaGrupoService {
    int newEstrategiaGrupo(EstrategiaGrupoDto dto);
    Optional<EstrategiaGrupoDto> getEstrategiaGrupoById(long id);
    void deleteEstrategiaGrupoById(long id);
    void deleteEstrategiaGrupo(EstrategiaGrupoDto dto);
    List<EstrategiaGrupoDto> findAll();
    Optional<EstrategiaGrupoDto> updateEstrategiaGrupo(EstrategiaGrupoDto dto);
}
