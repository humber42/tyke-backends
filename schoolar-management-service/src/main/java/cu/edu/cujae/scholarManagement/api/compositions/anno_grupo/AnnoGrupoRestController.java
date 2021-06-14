package cu.edu.cujae.scholarManagement.api.compositions.anno_grupo;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AnnoGrupoDto;
import cu.edu.cujae.scholarManagement.service.AnnoGrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.ANNO_GRUPO_URL)
public class AnnoGrupoRestController {

    @Autowired
    AnnoGrupoService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.AnnoGrupoUrls.ANNO_GRUPO_SAVE)
    public int saveAnnoGrupo(@RequestBody AnnoGrupoRequest request){
        return service.saveAnnoGrupo(mapper.map(request, AnnoGrupoDto.class));
    }
}
