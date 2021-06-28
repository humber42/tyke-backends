package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaRequest;
import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaRequestWithAllThings;
import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.EstrategiaDto;
import cu.edu.cujae.tykestrategy.service.EstrategiaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.ESTRATEGIA_API)
public class EstrategiaRestController {

    @Autowired
    EstrategiaService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<EstrategiaResponse> getAllEstrategia(){
        return service.findAllEstrategia().stream()
                .map(entity->mapper.map(entity, EstrategiaResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public EstrategiaResponse getEstrategiaById(@RequestParam("id") long id){
        return service.getEstrategiaById(id)
                .map(entity->mapper.map(entity,EstrategiaResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteEstrategia(@RequestBody EstrategiaResponse response){
        service.deleteEstrategia(mapper.map(response, EstrategiaDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteEstrategiaById(@RequestParam("id")long id){
        service.deleteEstrategiaById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveEstrategia(@RequestBody EstrategiaRequest request){
        return service.saveEstrategia(mapper.map(request, EstrategiaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public EstrategiaResponse updateEstrategia(@RequestBody EstrategiaResponse response){
        return service.updateEstrategiaDto(
                mapper.map(response,EstrategiaDto.class)
        )
                .map(entity->mapper.map(entity,EstrategiaResponse.class))
                .get();
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE_STRATEGY_SPECIAL_ENDPOINT)
    public int saveStrategyWithAll(@RequestBody EstrategiaRequestWithAllThings request){
        return service.saveEstrategiaComplete(request);
    }
}
