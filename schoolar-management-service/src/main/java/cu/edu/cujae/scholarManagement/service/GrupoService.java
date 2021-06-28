package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.api.grupo.GrupoRequest;
import cu.edu.cujae.scholarManagement.dto.GrupoDto;
import cu.edu.cujae.scholarManagement.dto.GrupoToStrategy;

import java.util.List;

public interface GrupoService {

    GrupoDto getGrupoById(int id);
    GrupoDto getGrupoByName(String name);
    List<GrupoDto> findAllGrupo();
    GrupoDto saveGrupo(GrupoRequest dto);
    GrupoDto updateGrupo(GrupoDto dto);
    GrupoDto deleteGrupoByName(String name);
    GrupoDto deleteGrupoById(int id);
    List<GrupoDto> findAllGrupoByCarrera(String carrera, int idProfesor);
    List<GrupoDto> findAllGrupoBy(int idProfesor,String asignatura);

}
