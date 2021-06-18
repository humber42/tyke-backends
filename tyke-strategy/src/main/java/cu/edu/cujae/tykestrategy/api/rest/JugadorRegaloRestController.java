package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.jugador_regalo.JugadorRegaloRequest;
import cu.edu.cujae.tykestrategy.api.models.jugador_regalo.JugadorRegaloResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.JugadorRegaloDto;
import cu.edu.cujae.tykestrategy.service.JugadorRegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.JUGADOR_REGALO_API)
public class JugadorRegaloRestController {

    @Autowired
    JugadorRegaloService service;
    @Autowired
    Mapper mapper;

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<JugadorRegaloResponse> getAllJugadorRegalo(){
        return service.findAllJugadorRegalo()
                .stream()
                .map(entity->mapper.map(entity,JugadorRegaloResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public JugadorRegaloResponse getJugadorRegalo(@RequestParam("id") long id){
        return service.getJugadorRegaloById(id)
                .map(entity->mapper.map(entity, JugadorRegaloResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteJugadorRegalo(@RequestBody JugadorRegaloResponse request){
        service.deleteJugadorRegalo(mapper.map(request, JugadorRegaloDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID, params = "id")
    public void deleteJugadorRegaloById(@RequestParam("id") long id){
        service.deleteJugadorRegaloById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveJugadorRegalo(@RequestBody JugadorRegaloRequest regaloRequest){
        return service.saveJugadorRegalo(mapper.map(regaloRequest,JugadorRegaloDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public JugadorRegaloResponse updateJugadorRegalo(@RequestBody JugadorRegaloResponse request){
        return service.updateJugadorRegalo(mapper.map(request, JugadorRegaloDto.class))
                .map(entity->mapper.map(entity,JugadorRegaloResponse.class))
                .get();
    }

}
