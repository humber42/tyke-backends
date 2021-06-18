package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_grupo;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorGrupoDto;
import cu.edu.cujae.scholarManagement.service.AsignaturaProfesorGrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.ASIGNATURA_PROFESOR_ESTUDIANTE_URL)
public class AsignaturaProfesorGrupoRestController {
    @Autowired
    AsignaturaProfesorGrupoService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.AsignaturaProfesorGrupoUrls.ASIGNATURA_PROFESOR_GRUPO_SAVE)
    public int saveAsignaturaProfesorEstudiante(@RequestBody AsignaturaProfesorGrupoRequest request){
        return service.saveAsignaturaProfesorGrupo(mapper.map(request, AsignaturaProfesorGrupoDto.class));
    }

    @PostMapping(WebResourceKeyConstants.AsignaturaProfesorGrupoUrls.ASIGNATURA_PROFESOR_LIST_GRUPO_SAVE)
    public int saveAsignaturaProfesorListGrupo(@RequestBody AsignaturaProfesorListGroupRequest request){
        return service.saveByListGrupoAsignaturaProfesor(mapper.map(request,AsignaturaProfesorListGroupRequest.class));
    }
}
