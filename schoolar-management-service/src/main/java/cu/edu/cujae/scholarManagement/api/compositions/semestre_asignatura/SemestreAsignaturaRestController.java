package cu.edu.cujae.scholarManagement.api.compositions.semestre_asignatura;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.SemestreAsignaturaDto;
import cu.edu.cujae.scholarManagement.service.SemestreAsignaturaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants.SEMESTRE_ASIGNATURA_URL;

@RestController
@RequestMapping(SEMESTRE_ASIGNATURA_URL)
public class SemestreAsignaturaRestController {
    @Autowired
    SemestreAsignaturaService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.SemestreAsignaturaUrls.SEMESTRE_ASIGNATURA_SAVE)
    public int saveSemestreAsignatura(@RequestBody SemestreAsignaturaRequest request){
        return service.saveSemestreAsignatura(mapper.map(request, SemestreAsignaturaDto.class));
    }
}
