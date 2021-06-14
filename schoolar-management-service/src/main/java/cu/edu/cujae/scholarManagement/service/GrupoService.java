package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.GrupoDto;

import java.util.List;

public interface GrupoService {

    GrupoDto getGrupoById(int id);
    GrupoDto getGrupoByName(String name);
    List<GrupoDto> findAllGrupo();
    GrupoDto saveGrupo(GrupoDto dto);
    GrupoDto updateGrupo(GrupoDto dto);
    GrupoDto deleteGrupoByName(String name);
    GrupoDto deleteGrupoById(int id);
}
