package cu.edu.cujae.questionservice.api.pista;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.PistaDto;
import cu.edu.cujae.questionservice.services.PistaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.PISTA_API)
public class PistaRestController {

    @Autowired
    PistaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<PistaResponse> getAllPistas() {
        return service.getAllPistas().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.PistaUrls.PISTA_GET_BY_TYPE, params = "type")
    public List<PistaResponse> getAllPïstaByType(@RequestParam String type) {
        return service.getPistaByTipo(type).stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.PistaUrls.PISTA_GET_BY_ID, params = "id")
    public PistaResponse getPistaById(@RequestParam long id) {
        return service.findOnePista(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.PistaUrls.PISTA_DELETE_BY_ID, params = "id")
    public PistaResponse deletePistaById(@RequestParam long id) {
        return convertir(service.deletePistaById(id));
    }

    @PostMapping(WebResourceKeyConstants.PistaUrls.PISTA_SAVE)
    public int savePista(@RequestBody PistaRequest request) {
        return service.savePista(mapper.map(request, PistaDto.class));
    }

    @PostMapping(WebResourceKeyConstants.PistaUrls.PISTA_UPDATE)
    public PistaResponse updatePista(@RequestBody PistaResponse request) {
        return convertir(service.updatePista(mapper.map(request, PistaDto.class)));
    }

    private PistaResponse convertir(PistaDto dto) {
        return mapper.map(dto, PistaResponse.class);
    }
}
