package cu.edu.cujae.scholarManagement.api.compositions.asignatura_profesor_estudiante;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorEstudianteDto;
import cu.edu.cujae.scholarManagement.service.AsignaturaProfesorEstudianteService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.ASIGNATURA_PROFESOR_ESTUDIANTE_URL)
public class AsignaturaProfesorEstudianteRestController {
    @Autowired
    AsignaturaProfesorEstudianteService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.AsignaturaProfesorEstudianteUrls.ASIGNATURA_PROFESOR_ESTUDIANTE_SAVE)
    public int saveAsignaturaProfesorEstudiante(@RequestBody AsignaturaProfesorEstudianteRequest request){
        return service.saveAsignaturaProfesorEstudiante(mapper.map(request, AsignaturaProfesorEstudianteDto.class));
    }
}
