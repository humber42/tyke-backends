package cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo;

import cu.edu.cujae.questionservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.questionservice.dto.BonificacionPreguntaTiempoDto;
import cu.edu.cujae.questionservice.services.BonificacionPreguntaTiempoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.BONIFICACION_PREGUNTA_TIEMPO_API)
public class BonificacionPreguntaTiempoRestController {

    @Autowired
    Mapper mapper;
    @Autowired
    BonificacionPreguntaTiempoService service;

    @GetMapping
    public List<BonificacionPreguntaTiempoResponse> getAll() {
        return service.getAll().stream().map(this::mappear).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.BonificacionPreguntaTiempoUrls.BONIFICACION_PREGUNTA_TIEMPO_GET_BY_ID, params = "id")
    public BonificacionPreguntaTiempoResponse getOne(@RequestParam long id) {
        return service.getOne(id).map(this::mappear).get();
    }

    @DeleteMapping(value = WebResourceKeyConstants.BonificacionPreguntaTiempoUrls.BONIFICACION_PREGUNTA_TIEMPO_DELETE_BY_ID, params = "id")
    public BonificacionPreguntaTiempoResponse deleteById(@RequestParam long id) {
        return service.deleteById(id).map(this::mappear).get();
    }

    @PostMapping(WebResourceKeyConstants.BonificacionPreguntaTiempoUrls.BONIFICACION_PREGUNTA_TIEMPO_SAVE)
    public BonificacionPreguntaTiempoResponse save(@RequestBody BonificacionPreguntaTiempoRequest request) {
        return service
                .saveBonificacion(
                        mapper.map(request, BonificacionPreguntaTiempoDto.class)
                ).map(this::mappear)
                .get();
    }

    @PostMapping(WebResourceKeyConstants.BonificacionPreguntaTiempoUrls.BONIFICACION_PREGUNTA_TIEMPO_UPDATE)
    public BonificacionPreguntaTiempoResponse save(@RequestBody BonificacionPreguntaTiempoResponse request) {
        return service
                .updateBonificacion(
                        mapper.map(request, BonificacionPreguntaTiempoDto.class)
                ).map(this::mappear)
                .get();
    }


    private BonificacionPreguntaTiempoResponse mappear(BonificacionPreguntaTiempoDto dto) {
        return mapper.map(dto, BonificacionPreguntaTiempoResponse.class);
    }
}
