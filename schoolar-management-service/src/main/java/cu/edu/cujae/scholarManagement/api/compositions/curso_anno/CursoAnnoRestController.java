package cu.edu.cujae.scholarManagement.api.compositions.curso_anno;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.CursoAnnoDto;
import cu.edu.cujae.scholarManagement.service.CursoAnnoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants.CURSO_ANNO_URL;

@RestController
@RequestMapping(CURSO_ANNO_URL)
public class CursoAnnoRestController {

    @Autowired
    CursoAnnoService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.CursoAnnoUrls.CURSO_ANNO_SAVE)
    public int saveCursoAnno(@RequestBody CursoAnnoRequest request){
        return service.saveCursoAnno(mapper.map(request, CursoAnnoDto.class));
    }
}
