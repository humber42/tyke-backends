package cu.edu.cujae.scholarManagement.api.asignatura;


import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AsignaturaDto;
import cu.edu.cujae.scholarManagement.service.AsignaturaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.ASIGNATURA_URL)
public class AsignaturaRestController {

    @Autowired
    AsignaturaService service;

    @Autowired
    Mapper mapper;

    @GetMapping
    public List<AsignaturaResponse> getAllAsignaturas(){
        return service.getAllAsignaturas().stream().map(dto -> mapper.map(dto, AsignaturaResponse.class)).collect(Collectors.toList());
    }

    @PostMapping(WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_SAVE)
    public AsignaturaResponse saveAsignatura(@RequestBody AsignaturaRequest dto){
        return mapper.map(service.saveAsignatura(AsignaturaDto.builder().nombre(dto.getNombre()).activo(dto.isActivo()).build()), AsignaturaResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_GET_ONE_BY_NAME,params = "name")
    public AsignaturaResponse searchByNameAsignatura(@RequestParam String name){
        return mapper.map(service.findByNameAsignatura(name), AsignaturaResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_GET_BY_NAME_PATH)
    public AsignaturaResponse searchByPathNameAsignatura(@PathVariable("name") String name){
        return mapper.map(service.findByNameAsignatura(name), AsignaturaResponse.class);
    }

    @GetMapping(WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_ACTIVE)
    public List<AsignaturaResponse> getActiveAsignaturas(){
        return service.activeAsignatura().stream().map(dto->mapper.map(dto,AsignaturaResponse.class)).collect(Collectors.toList());
    }

    @DeleteMapping(value = WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_DELETE_BY_NAME,params = "name")
    public AsignaturaResponse deleteAsignatura(@RequestParam String name){
        return mapper.map(service.deleteByAsignaturaName(name), AsignaturaResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_GET_BY_ID)
    public AsignaturaResponse getOne(@PathVariable int id){
        return mapper.map(service.findOne(id), AsignaturaResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.AsignaturaUrls.ASIGNATURA_UPDATE)
    public AsignaturaResponse updateAsignatura(@RequestBody AsignaturaResponse response){
        return mapper.map(service.updateAsignatura(mapper.map(response, AsignaturaDto.class)), AsignaturaResponse.class);
    }
}
