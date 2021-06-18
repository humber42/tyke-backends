package cu.edu.cujae.questionservice.api.compositions.preguntaRespuesta;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.PreguntaRespuestaDto;
import cu.edu.cujae.questionservice.services.PreguntaRespuestaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(WebResourceKeyConstants.PREGUNTA_RESPUESTA_API)
public class PreguntaRespuestaRestController {

    @Autowired
    PreguntaRespuestaService service;
    @Autowired
    Mapper mapper;

    @PostMapping(WebResourceKeyConstants.PreguntaRespuestaUrls.PREGUNTA_RESPUESTA_SAVE)
    public int save(@RequestBody PreguntaRespuestaRequest request){
        return service.savePreguntaRespuesta(mapper.map(request, PreguntaRespuestaDto.class));
    }


    private PreguntaRespuestaResponse mappear(PreguntaRespuestaDto dto){
        return mapper.map(dto, PreguntaRespuestaResponse.class);
    }
}
