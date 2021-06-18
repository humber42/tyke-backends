package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.puntuacion.PuntuacionRequest;
import cu.edu.cujae.tykestrategy.api.models.puntuacion.PuntuacionResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.PuntuacionDto;
import cu.edu.cujae.tykestrategy.service.PuntuacionService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.PUNTUACION_API)
public class PuntuacionRestController {
    @Autowired
    PuntuacionService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<PuntuacionResponse> getAllPuntuacion(){
        return service.findAllPuntuacion()
                .stream()
                .map(entity->mapper.map(entity, PuntuacionResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public PuntuacionResponse getPuntuacionByID(@RequestParam("id") long id){
        return service.getPuntuacionById(id)
                .map(entity->mapper.map(entity,PuntuacionResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deletePuntuacionByID(@RequestParam("id") long id){
        service.deletePuntuacionById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deletePuntuacion(@RequestBody PuntuacionResponse request){
        service.deletePuntuacion(mapper.map(request, PuntuacionDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public PuntuacionResponse savePuntuacion(@RequestBody PuntuacionRequest request){
        return service.savePuntuacion(mapper.map(request, PuntuacionDto.class))
                .map(entity->mapper.map(entity, PuntuacionResponse.class))
                .get();
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public PuntuacionResponse updatePuntuacion(@RequestBody PuntuacionResponse request){
        return service.updatePuntuacion(mapper.map(request, PuntuacionDto.class))
                .map(entity->mapper.map(entity,PuntuacionResponse.class))
                .get();
    }
}
