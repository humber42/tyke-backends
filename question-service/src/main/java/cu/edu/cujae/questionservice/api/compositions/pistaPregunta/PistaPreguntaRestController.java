package cu.edu.cujae.questionservice.api.compositions.pistaPregunta;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.PistaPreguntaDto;
import cu.edu.cujae.questionservice.services.PistaPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.PISTA_PREGUNTA_API)
public class PistaPreguntaRestController {

    @Autowired
    PistaPreguntaService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.PistaPreguntaUrls.PISTA_PREGUNTA_SAVE)
    public int save(@RequestBody PistaPreguntaRequest request){
        return service.save(mapper.map(request, PistaPreguntaDto.class));
    }

    private PistaPreguntaResponse mappear(PistaPreguntaDto dto){
        return mapper.map(dto, PistaPreguntaResponse.class);
    }
}
