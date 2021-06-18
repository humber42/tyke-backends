package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.jugador_estrategia.JugadorEstrategiaRequest;
import cu.edu.cujae.tykestrategy.api.models.jugador_estrategia.JugadorEstrategiaResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.JugadorEstrategiaDto;
import cu.edu.cujae.tykestrategy.service.JugadorEstrategiaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.JUGADOR_ESTRATEGIA_API)
public class JugadorEstrategiaRestController {

    @Autowired
    JugadorEstrategiaService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<JugadorEstrategiaResponse> getAllJugadorEstrategia(){
        return service.findAllJugadorEstrategia()
                .stream()
                .map(entity->mapper.map(entity,JugadorEstrategiaResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public JugadorEstrategiaResponse getJugadorEtrategiaById(@RequestParam("id") long id){
        return service.getJugadorEstrategiaById(id)
                .map(entity->mapper.map(entity, JugadorEstrategiaResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteJugadorEstrategia(@RequestBody JugadorEstrategiaResponse request){
        service.deleteJugadorEstrategia(mapper.map(request, JugadorEstrategiaDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteJugadorEstrategiaById(@RequestParam("id") long id){
        service.deleteJugadorEstrategiaById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveJugadorEstrategia(@RequestBody JugadorEstrategiaRequest request){
        return service.saveJugadorEstrategia(mapper.map(request, JugadorEstrategiaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public JugadorEstrategiaResponse updateJugadorEstrategia(@RequestBody JugadorEstrategiaResponse request){
        return service.updateJugadorEstrategia(mapper.map(request, JugadorEstrategiaDto.class))
                .map(entity->mapper.map(entity,JugadorEstrategiaResponse.class))
                .get();
    }
}
