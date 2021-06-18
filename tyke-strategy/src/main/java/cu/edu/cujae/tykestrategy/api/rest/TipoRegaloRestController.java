package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.tipo_regalo.TipoRegaloRequest;
import cu.edu.cujae.tykestrategy.api.models.tipo_regalo.TipoRegaloResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.TipoRegaloDto;
import cu.edu.cujae.tykestrategy.service.TipoRegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.TIPO_REGALO_API)
public class TipoRegaloRestController {
    @Autowired
    TipoRegaloService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<TipoRegaloResponse> getAllTipoRegalo(){
        return service.findAllTipoRegalo()
                .stream()
                .map(entity->mapper.map(entity, TipoRegaloResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public TipoRegaloResponse getTipoRegaloByID(@RequestParam("id") long id){
        return service.getTipoRegaloById(id)
                .map(entity->mapper.map(entity,TipoRegaloResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteTipoRegaloByID(@RequestParam("id") long id){
        service.deleteTipoRegaloById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteTipoRegalo(@RequestBody TipoRegaloResponse request){
        service.deleteTipoRegalo(mapper.map(request, TipoRegaloDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public TipoRegaloResponse saveTipoRegalo(@RequestBody TipoRegaloRequest request){
        return service.saveTipoRegalo(mapper.map(request, TipoRegaloDto.class))
                .map(entity->mapper.map(entity, TipoRegaloResponse.class))
                .get();
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public TipoRegaloResponse updateTipoRegalo(@RequestBody TipoRegaloResponse request){
        return service.updateTipoRegalo(mapper.map(request, TipoRegaloDto.class))
                .map(entity->mapper.map(entity,TipoRegaloResponse.class))
                .get();
    }
}
