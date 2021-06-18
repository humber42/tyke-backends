package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.estrategia_tema.EstrategiaTemaRequest;
import cu.edu.cujae.tykestrategy.api.models.estrategia_tema.EstrategiaTemaResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.EstrategiaTemaDto;
import cu.edu.cujae.tykestrategy.service.EstrategiaTemaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.ESTRATEGIA_TEMA_API)
public class EstrategiaTemaRestController {

    @Autowired
    EstrategiaTemaService service;
    @Autowired
    Mapper mapper;


    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<EstrategiaTemaResponse> getAllEstrategiaTema(){
        return service.findAllEstrategiaTema().stream()
                .map(entity->mapper.map(entity, EstrategiaTemaResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public EstrategiaTemaResponse getEstrategiaTemaById(@RequestParam("id") long id){
        return service.getEstrategiaTemaById(id)
                .map(entity->mapper.map(entity,EstrategiaTemaResponse.class))
                .get();
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteEstrategiaTema(@RequestBody EstrategiaTemaResponse response){
        service.deleteEstrategiaTema(mapper.map(response, EstrategiaTemaDto.class));
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteEstrategiaTemaById(@RequestParam("id") long id){
        service.deleteEstrategiaTemaById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveEstrategiaTema(@RequestBody EstrategiaTemaRequest request){
        return service.saveEstrategiaTema(mapper.map(request, EstrategiaTemaDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public EstrategiaTemaResponse updateEstrategiaTema(@RequestBody EstrategiaTemaResponse request){
        return service.updateEstrategiaDto(mapper.map(request, EstrategiaTemaDto.class))
                .map(entity-> mapper.map(entity,EstrategiaTemaResponse.class))
                .get();
    }
}
