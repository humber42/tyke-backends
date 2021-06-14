package cu.edu.cujae.scholarManagement.api.compositions.anno_semestre;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AnnoSemestreDto;
import cu.edu.cujae.scholarManagement.service.AnnoSemestreService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.ANNO_SEMESTRE_URL)
public class AnnoSemestreRestController {

    @Autowired
    AnnoSemestreService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.AnnoSemestreUrls.ANNO_SEMESTRE_SAVE)
    public int saveAnnoSemestre(@RequestBody AnnoSemestreRequest request){
        return service.saveAnnoSemestre(mapper.map(request, AnnoSemestreDto.class));
    }
}
