package cu.edu.cujae.scholarManagement.api.grupo;


import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.GrupoDto;
import cu.edu.cujae.scholarManagement.service.GrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.GRUPO_URL)
public class GrupoRestController {

    @Autowired
    GrupoService service;
    @Autowired
    Mapper mapper;


    @GetMapping
    public List<GrupoResponse> findAllGrupos(){
        return service.findAllGrupo().stream().map(dto -> mapper.map(dto,GrupoResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.GrupoUrls.GRUPO_GET_BY_ID,params = "id")
    public GrupoResponse getGrupoById(@RequestParam int id){
        return mapper.map(service.getGrupoById(id), GrupoResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.GrupoUrls.GRUPO_GET_BY_NAME,params = "name")
    public GrupoResponse getGrupoByName(@RequestParam String name){
        return mapper.map(service.getGrupoByName(name), GrupoResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.GrupoUrls.GRUPO_SAVE)
    public GrupoResponse saveGrupo(@RequestBody GrupoRequest request){
        return mapper.map(service.saveGrupo(request), GrupoResponse.class);
    }
    @PostMapping(WebResourceKeyConstants.GrupoUrls.GRUPO_UPDATE)
    public GrupoResponse updateGrupo(@RequestBody GrupoResponse request){
        return mapper.map(service.updateGrupo(mapper.map(request, GrupoDto.class)), GrupoResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.GrupoUrls.GRUPO_DELETE_BY_ID,params = "id")
    public GrupoResponse deleteGrupoById(int id){
        return mapper.map(service.deleteGrupoById(id), GrupoResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.GrupoUrls.GRUPO_DELETE_BY_NAME,params = "name")
    public GrupoResponse deleteGrupoByName(String name){
        return mapper.map(service.deleteGrupoByName(name), GrupoResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.GrupoUrls.GRUPO_GET_ALLS_BY_CARRERA,params = {"carrera","idProfesor"})
    public List<GrupoResponse> getAllByCareer(@RequestParam("carrera") String carrera, @RequestParam("idProfesor") int idProfesor){
        return service.findAllGrupoByCarrera(carrera, idProfesor)
                .stream()
                .map(entity->mapper.map(entity, GrupoResponse.class))
                .collect(Collectors.toList());
    }
}
