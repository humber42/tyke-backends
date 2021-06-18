package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.insignia.InsigniaRequest;
import cu.edu.cujae.tykestrategy.api.models.insignia.InsigniaResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.InsigniaDto;
import cu.edu.cujae.tykestrategy.service.InsigniaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.INSIGNIA_API)
public class InsigniaRestController {

    @Autowired
    InsigniaService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<InsigniaResponse> getAllInsignias(){
        return service.findAllInsignia().stream()
                .map(entity->mapper.map(entity, InsigniaResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public InsigniaResponse getInsigniaById(@RequestParam long id){
        return service.getInsigniaById(id)
                .map(entity->mapper.map(entity,InsigniaResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteInsignia(@RequestBody InsigniaResponse response){
        service.deleteInsignia(mapper.map(response, InsigniaDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteInsigniaById(@RequestParam("id") long id){
        service.deleteInsigniaById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveInsignia(@RequestBody InsigniaRequest request){
        return service.saveInsignia(mapper.map(request, InsigniaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public InsigniaResponse updateInsignia(@RequestBody InsigniaResponse request){
        return service.updateInsignia(mapper.map(request, InsigniaDto.class))
                .map(entity->mapper.map(entity,InsigniaResponse.class))
                .get();
    }
}
