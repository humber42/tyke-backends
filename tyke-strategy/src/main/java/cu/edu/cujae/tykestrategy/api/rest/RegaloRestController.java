package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloRequest;
import cu.edu.cujae.tykestrategy.api.models.regalo.RegaloResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.RegaloDto;
import cu.edu.cujae.tykestrategy.service.RegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.REGALO_API)
public class RegaloRestController {
    @Autowired
    RegaloService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<RegaloResponse> getAllRegalo(){
        return service.findAllRegalo()
                .stream()
                .map(entity->mapper.map(entity, RegaloResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public RegaloResponse getRegaloByID(@RequestParam("id") long id){
        return service.getRegaloById(id)
                .map(entity->mapper.map(entity,RegaloResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteRegaloByID(@RequestParam("id") long id){
        service.deleteRegaloById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteRegalo(@RequestBody RegaloResponse request){
        service.deleteRegalo(mapper.map(request, RegaloDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveRegalo(@RequestBody RegaloRequest request){
        return service.saveRegalo(mapper.map(request, RegaloDto.class));

    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public RegaloResponse updateRegalo(@RequestBody RegaloResponse request){
        return service.updateRegalo(mapper.map(request, RegaloDto.class))
                .map(entity->mapper.map(entity,RegaloResponse.class))
                .get();
    }

}
