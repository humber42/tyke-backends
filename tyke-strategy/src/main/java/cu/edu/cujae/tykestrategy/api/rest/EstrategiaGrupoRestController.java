package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.estrategia_grupo.EstrategiaGrupoRequest;
import cu.edu.cujae.tykestrategy.api.models.estrategia_grupo.EstrategiaGrupoResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.EstrategiaGrupoDto;
import cu.edu.cujae.tykestrategy.service.EstrategiaGrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebServiceResourceKeyConstants.ESTRATEGIA_GRUPO_API)
public class EstrategiaGrupoRestController {

    @Autowired
    EstrategiaGrupoService service;
    @Autowired
    Mapper mapper;


    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<EstrategiaGrupoResponse> getAllEstrategiaGrupo(){
        return service.findAll().stream()
                .map(entity->mapper.map(entity,EstrategiaGrupoResponse.class))
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID,params = "id")
    public EstrategiaGrupoResponse getEstrategiaGrupoById(@RequestParam("id") long id){
        return service.getEstrategiaGrupoById(id)
                .map(entity->mapper.map(entity, EstrategiaGrupoResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteEstrategiaGrupo(@RequestBody EstrategiaGrupoResponse request){
        service.deleteEstrategiaGrupo(
                mapper.map(request, EstrategiaGrupoDto.class)
        );
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteEstrategiaGrupoById(@RequestParam("id") long id){
        service.deleteEstrategiaGrupoById(id);
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public int saveEstrategiaGrupo(@RequestBody EstrategiaGrupoRequest request){
        return service.newEstrategiaGrupo(
                mapper.map(request, EstrategiaGrupoDto.class)
        );
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public EstrategiaGrupoResponse updateEstrategiaGrupo(@RequestBody EstrategiaGrupoResponse response){
        return service.updateEstrategiaGrupo(mapper.map(response, EstrategiaGrupoDto.class))
                .map(entity->mapper.map(entity, EstrategiaGrupoResponse.class))
                .get();
    }
}
