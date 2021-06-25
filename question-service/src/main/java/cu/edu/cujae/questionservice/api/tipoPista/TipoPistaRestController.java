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
    public List<TipoPistaDto> getAllTipoPista() {
        return service.getAllTipoPista();
    }

    @GetMapping(params = "id", value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_GET_BY_ID)
    public TipoPistaDto getByIdTipoPista(@RequestParam long id) {
        return service.getOneTipoPista(id).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_DELETE_BY_ID, params = "id")
    public TipoPistaDto deleteTipoPista(@RequestParam long id) {
        return service.delete(id);
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_SAVE)
    public TipoPistaDto saveTipoPista(@RequestBody TipoPistaRequest request) {
        return service.save(mapper.map(request, TipoPistaDto.class));
    }

    @PostMapping(value = WebResourceKeyConstants.TipoPistaUrls.TIPO_PISTA_UPDATE)
    public TipoPistaDto updateTipoPista(@RequestBody TipoPistaResponse request) {
        return service.update(mapper.map(request, TipoPistaDto.class));
    }



}
