package cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AsignaturaTemaDto;
import cu.edu.cujae.scholarManagement.service.AsignaturaTemaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.ASIGNATURA_TEMA_URL)
public class AsignaturaTemaRestController {
    @Autowired
    AsignaturaTemaService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.AsignaturaTemaUrls.ASIGANTURA_TEMA_SAVE)
    public int savaAsignaturaTema(@RequestBody AsignaturaTemaRequest request){
        return service.saveAsignaturaTema(mapper.map(request, AsignaturaTemaDto.class));
    }
}
