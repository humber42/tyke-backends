package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.jugador_desafio.JugadorDesafioRequest;
import cu.edu.cujae.tykestrategy.api.models.jugador_desafio.JugadorDesafioResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.JugadorDesafioDto;
import cu.edu.cujae.tykestrategy.service.JugadorDesafioService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.JUGADOR_DESAFIO_API)
public class JugadorDesafioRestController {

    @Autowired
    JugadorDesafioService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<JugadorDesafioResponse> getAllJugadorDesafio(){
        return service.findAllJugadorDesafio().stream()
                .map(entity->mapper.map(entity,JugadorDesafioResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public JugadorDesafioResponse getByIdJugadorDesafio(@RequestParam("id") long id){
        return service.getJugadorDesafioById(id)
                .map(entity->mapper.map(entity,JugadorDesafioResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteJugadorDesafio(@RequestBody JugadorDesafioResponse request){
        service.deleteJugadorDesafio(mapper.map(request, JugadorDesafioDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteJugadorDesafioById(@RequestParam("id") long id){
        service.deleteJugadorDesafioById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveJugadorDesafio(@RequestBody JugadorDesafioRequest request){
        return service.saveJugadorDesafio(mapper.map(request, JugadorDesafioDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public JugadorDesafioResponse updateJugadorDesafio(@RequestBody JugadorDesafioResponse request){
        return service.updateJugadorDesafio(mapper.map(request, JugadorDesafioDto.class))
                .map(entity->mapper.map(entity, JugadorDesafioResponse.class))
                .get();
    }


}
