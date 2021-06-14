package cu.edu.cujae.scholarManagement.api.compositions.facultad_curso;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.FacultadCursoDto;
import cu.edu.cujae.scholarManagement.service.FacultadCursoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants.FACULTAD_CURSO_URL;

@RestController
@RequestMapping(FACULTAD_CURSO_URL)
public class FacultadCursoRestController {
    @Autowired
    FacultadCursoService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.FacultadCursoUrls.FACULTAD_CURSO_SAVE)
    public int saveFacultadCUrso(@RequestBody FacultadCursoRequest request){
        return service.saveFacultadCurso(mapper.map(request, FacultadCursoDto.class));
    }

}
