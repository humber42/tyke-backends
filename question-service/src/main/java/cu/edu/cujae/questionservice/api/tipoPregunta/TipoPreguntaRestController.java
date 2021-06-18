package cu.edu.cujae.questionservice.api.tipoPregunta;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.TipoPreguntaDto;
import cu.edu.cujae.questionservice.services.TipoPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.TIPO_PREGUNTA_API)
public class TipoPreguntaRestController {

    @Autowired
    Mapper mapper;
    @Autowired
    TipoPreguntaService service;

    @GetMapping
    public List<TipoPreguntaResponse> getAllTipoPregunta() {
        return service.getAllTipoPregunta().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.TipoPreguntaUrls.TIPO_PREGUNTA_GET_BY_ID, params = "id")
    public TipoPreguntaResponse getByIdTipoPregunta(@RequestParam long id) {
        return service.getOneTipoPregunta(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.TipoPreguntaUrls.TIPO_PREGUNTA_DELETE_BY_ID, params = "id")
    public TipoPreguntaResponse deleteByIdTipoPregunta(@RequestParam long id) {
        return convertir(service.delete(id));
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPreguntaUrls.TIPO_PREGUNTA_SAVE)
    public TipoPreguntaResponse saveTipoPregunta(@RequestBody TipoPreguntaRequest request) {
        return convertir(service.save(mapper.map(request, TipoPreguntaDto.class)));
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPreguntaUrls.TIPO_PREGUNTA_UPDATE)
    public TipoPreguntaResponse updateTipoPregunta(@RequestBody TipoPreguntaResponse request) {
        return convertir(service.update(mapper.map(request, TipoPreguntaDto.class)));
    }

    private TipoPreguntaResponse convertir(TipoPreguntaDto dto) {
        return mapper.map(dto, TipoPreguntaResponse.class);
    }
}
