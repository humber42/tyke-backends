package cu.edu.cujae.scholarManagement.api.compositions.estudiante_grupo;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.EstudianteGrupoDto;
import cu.edu.cujae.scholarManagement.service.EstudianteGrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants.ESTUDIANTE_GRUPO_URL;

@RestController
@RequestMapping(ESTUDIANTE_GRUPO_URL)
public class EstudianteGrupoRestController {

    @Autowired
    Mapper mapper;
    @Autowired
    EstudianteGrupoService service;

    @PostMapping(WebResourceKeyConstants.EstudianteGrupoUrls.ESTUDIANTE_GRUPO_SAVE)
    public int saveEstudianteGrupo(@RequestBody EstudianteGrupoRequest request){
        return service.saveEstudianteGrupo(mapper.map(request, EstudianteGrupoDto.class));
    }
}
