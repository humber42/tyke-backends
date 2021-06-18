package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.jugador_insignia.JugadorInsigniaRequest;
import cu.edu.cujae.tykestrategy.api.models.jugador_insignia.JugadorInsigniaResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.JugadorInsigniaDto;
import cu.edu.cujae.tykestrategy.service.JugadorInsigniaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.JUGADOR_INSIGNIA_API)
public class JugadorInsigniaRestController {

    @Autowired
    JugadorInsigniaService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<JugadorInsigniaResponse> getAllJugadorInsignia(){
        return service.findAllJugadorInsignia()
                .stream()
                .map(entity->mapper.map(entity,JugadorInsigniaResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public JugadorInsigniaResponse getJugadorInsigniaById(@RequestParam("id") long id){
        return service.getJugadorInsigniaById(id)
                .map(entty->mapper.map(entty,JugadorInsigniaResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID, params = "id")
    public void deleteJugadorInsignia(@RequestParam("id") long id){
        service.deleteJugadorInsigniaById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteJugadorInsigniaByID(@RequestBody JugadorInsigniaResponse request){
        service.deleteJugadorInsignia(mapper.map(request, JugadorInsigniaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveJugadorInsignia(@RequestBody JugadorInsigniaRequest request){
        return service.saveJugadorInsignia(mapper.map(request, JugadorInsigniaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public JugadorInsigniaResponse updateJugadorInsignia(@RequestBody JugadorInsigniaResponse request){
        return service.updateJugadorInsignia(mapper.map(request, JugadorInsigniaDto.class))
                .map(entity->mapper.map(entity,JugadorInsigniaResponse.class))
                .get();
    }
}
