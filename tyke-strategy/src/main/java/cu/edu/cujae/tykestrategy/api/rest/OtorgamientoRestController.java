package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.otorgamiento.OtorgamientoRequest;
import cu.edu.cujae.tykestrategy.api.models.otorgamiento.OtorgamientoResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.OtorgamientoDto;
import cu.edu.cujae.tykestrategy.service.OtorgamientoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.OTORGAMIENTO_API)
public class OtorgamientoRestController {
    @Autowired
    OtorgamientoService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<OtorgamientoResponse> getAllOtorgamiento(){
        return service.findAllOtorgamiento()
                .stream()
                .map(entity->mapper.map(entity, OtorgamientoResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public OtorgamientoResponse getOtorgamientoByID(@RequestParam("id") long id){
        return service.getOtorgamientoById(id)
                .map(entity->mapper.map(entity,OtorgamientoResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteOtorgamientoByID(@RequestParam("id") long id){
        service.deleteOtorgamientoById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteOtorgamiento(@RequestBody OtorgamientoResponse request){
        service.deleteOtorgamiento(mapper.map(request, OtorgamientoDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public OtorgamientoResponse saveOtorgamiento(@RequestBody OtorgamientoRequest request){
        return service.saveOtorgamiento(mapper.map(request, OtorgamientoDto.class))
                .map(entity->mapper.map(entity, OtorgamientoResponse.class))
                .get();
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public OtorgamientoResponse updateOtorgamiento(@RequestBody OtorgamientoResponse request){
        return service.updateOtorgamiento(mapper.map(request, OtorgamientoDto.class))
                .map(entity->mapper.map(entity,OtorgamientoResponse.class))
                .get();
    }

}
