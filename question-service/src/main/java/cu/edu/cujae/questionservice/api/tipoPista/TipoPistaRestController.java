package cu.edu.cujae.questionservice.api.tipoPista;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.TipoPistaDto;
import cu.edu.cujae.questionservice.services.TipoPistaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.TIPO_PISTA_API)
public class TipoPistaRestController {
    @Autowired
    TipoPistaService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<TipoPistaResponse> getAllTipoPista() {
        return service.getAllTipoPista().stream().map(this::convertir).collect(Collectors.toList());
    }

    @GetMapping(params = "id", value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_GET_BY_ID)
    public TipoPistaResponse getByIdTipoPista(@RequestParam long id) {
        return service.getOneTipoPista(id).map(this::convertir).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_DELETE_BY_ID, params = "id")
    public TipoPistaResponse deleteTipoPista(@RequestParam long id) {
        return convertir(service.delete(id));
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_SAVE)
    public TipoPistaResponse saveTipoPista(@RequestBody TipoPistaRequest request) {
        return convertir(service.save(mapper.map(request, TipoPistaDto.class)));
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_UPDATE)
    public TipoPistaResponse updateTipoPista(@RequestBody TipoPistaResponse request) {
        return convertir(service.update(mapper.map(request, TipoPistaDto.class)));
    }

    private TipoPistaResponse convertir(TipoPistaDto dto) {
        return mapper.map(dto, TipoPistaResponse.class);
    }

}
