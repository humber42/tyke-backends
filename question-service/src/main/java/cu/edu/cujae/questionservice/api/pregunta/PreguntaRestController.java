package cu.edu.cujae.questionservice.api.pregunta;


import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.PreguntaDto;
import cu.edu.cujae.questionservice.services.PreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.PREGUNTA_API)
public class PreguntaRestController {

    @Autowired
    PreguntaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<PreguntaResponse> getAllPreguntas() {
        return service.getAllPreguntas().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.PreguntaUrls.PREGUNTA_ALL_BY_SIGNATURE,params = "asignatura")
    public List<PreguntaResponse> getAllPreguntaBySignature(@RequestParam("asignatura")String asignatura){
        return service.getAllPreguntaByAsignatura(asignatura)
                .stream()
                .map(this::convertir)
                .collect(Collectors.toList());
    }



//    @GetMapping(value = WebResourceKeyConstants.PreguntaUrls.PREGUNTA_GET_BY_TYPE, params = "type")
//    public List<PreguntaResponse> getAllPreguntasByType(@RequestParam String type) {
//        return service.getAllPreguntasByTipo(type).stream().map(this::convertir).collect(Collectors.toList());
//    }

    @GetMapping(value = WebResourceKeyConstants.PreguntaUrls.PREGUNTA_GET_BY_ID, params = "id")
    public PreguntaResponse getPreguntaById(@RequestParam long id) {
        return service.findOnePregunta(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.PreguntaUrls.PREGUNTA_DELETE_BY_ID, params = "id")
    public PreguntaResponse deletePreguntaById(@RequestParam long id) {
        return convertir(service.deletePregunta(id));
    }

    @PostMapping(WebResourceKeyConstants.PreguntaUrls.PREGUNTA_SAVE)
    public int savePregunta(@RequestBody PreguntaRequest request) {
        return service.savePregunta(mapper.map(request, PreguntaDto.class));
    }

    @PostMapping(WebResourceKeyConstants.PreguntaUrls.PREGUNTA_UPDATE)
    public PreguntaResponse updatePregunta(@RequestBody PreguntaResponse request) {
        return convertir(service.updatePregunta(mapper.map(request, PreguntaDto.class)));
    }

    @PostMapping(WebResourceKeyConstants.PreguntaUrls.PREGUNTA_SAVE_COMPLETE)
    public PreguntaResponse savePreguntaWithAll(@RequestBody PreguntaRequestWithRespuestasCluesBonifications request){
        return convertir(service.savePreguntaWithCluesAndBonifications(request));
    }


    private PreguntaResponse convertir(PreguntaDto dto) {
        return mapper.map(dto, PreguntaResponse.class);
    }
}
