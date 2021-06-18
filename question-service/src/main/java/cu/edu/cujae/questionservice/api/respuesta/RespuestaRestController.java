package cu.edu.cujae.questionservice.api.respuesta;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.RespuestaDto;
import cu.edu.cujae.questionservice.services.RespuestaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.RESPUESTA_API)
public class RespuestaRestController {

    @Autowired
    RespuestaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<RespuestaResponse> getAllRespuestas() {
        return service.getAllRespuesta().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.RespuestaUrls.RESPUESTA_GET_BY_ID, params = "id")
    public RespuestaResponse getRespuestaById(@RequestParam long id) {
        return service.getOne(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.RespuestaUrls.RESPUESTA_DELETE_BY_ID, params = "id")
    public RespuestaResponse deleteRespuestaById(@RequestParam long id) {
        return convertir(service.delete(id));
    }

    @PostMapping(WebResourceKeyConstants.RespuestaUrls.RESPUESTA_SAVE)
    public RespuestaResponse saveRespuesta(@RequestBody RespuestaRequest request) {
        return convertir(service.save(mapper.map(request, RespuestaDto.class)));
    }

    @PostMapping(WebResourceKeyConstants.RespuestaUrls.RESPUESTA_UPDATE)
    public RespuestaResponse updateRespuesta(@RequestBody RespuestaResponse request) {
        return convertir(service.update(mapper.map(request, RespuestaDto.class)));
    }

    private RespuestaResponse convertir(RespuestaDto dto) {
        return mapper.map(dto, RespuestaResponse.class);
    }
}
