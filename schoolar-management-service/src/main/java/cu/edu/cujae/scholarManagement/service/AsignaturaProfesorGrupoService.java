package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo.AsignaturaProfesorListGroupRequest;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorGrupoDto;

public interface AsignaturaProfesorGrupoService {
    int saveAsignaturaProfesorGrupo(AsignaturaProfesorGrupoDto dto);
    int saveByListGrupoAsignaturaProfesor(AsignaturaProfesorListGroupRequest request);
}
