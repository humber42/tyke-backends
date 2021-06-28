package cu.edu.cujae.scholarManagement.api.tema;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema.AsignaturaTemaResponse;
import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.AsignaturaDto;
import cu.edu.cujae.scholarManagement.dto.AsignaturaTemaDto;
import cu.edu.cujae.scholarManagement.dto.TemaDto;
import cu.edu.cujae.scholarManagement.service.AsignaturaService;
import cu.edu.cujae.scholarManagement.service.AsignaturaTemaService;
import cu.edu.cujae.scholarManagement.service.TemaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.TEMA_URL)
public class TemaRestController {

    @Autowired
    TemaService service;
    @Autowired
    Mapper mapper;
    @Autowired
    AsignaturaService asignaturaService;
    @Autowired
    AsignaturaTemaService asignaturaTemaService;

    @GetMapping
    public List<TemaResponse> findAllTemas(){
        return service.findAlltema().stream().map(temaDto -> mapper.map(temaDto,TemaResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.TemaUrls.TEMA_GET_BY_ID,params = "id")
    public TemaResponse getTemaById(@RequestParam int id){
        return mapper.map(service.getTemaById(id), TemaResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.TemaUrls.TEMA_GET_BY_NAME,params = "name")
    public TemaResponse getTemaByName(@RequestParam String name){
        return mapper.map(service.getTemaByNombre(name), TemaResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.TemaUrls.TEMA_SAVE)
    public TemaResponse saveTema(@RequestBody TemaRequest request){
        TemaDto temaDto = service.saveTema(mapper.map(request,TemaDto.class));
        for (String asignature: request.getAsignaturas()
             ) {
            AsignaturaDto dto = asignaturaService.findByNameAsignatura(asignature);
            AsignaturaTemaDto asignaturaTemaDto =  AsignaturaTemaDto.builder().idAsignatura(dto.getId()).idTema(temaDto.getId()).build();
            asignaturaTemaService.saveAsignaturaTema(asignaturaTemaDto);
        }
        return mapper.map(service.getTemaByNombre(request.getNombre()), TemaResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.TemaUrls.TEMA_UPDATE)
    public TemaResponse updateTema(@RequestBody TemaRequestWithId request){
        deleteById(request.getId());
        return saveTema(mapper.map(request, TemaRequest.class));
    }

    @DeleteMapping(value = WebResourceKeyConstants.TemaUrls.TEMA_DELETE_BY_ID,params = "id")
    public TemaResponse deleteById(@RequestParam int id){
        return  mapper.map(service.deleteTemaById(id), TemaResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.TemaUrls.TEMA_DELETE_BY_NAME,params = "name")
    public TemaResponse deleteByName(@RequestParam String name){
        return mapper.map(service.deleteTemaByNombre(name), TemaResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.TemaUrls.TEMA_BY_ASIGNATURA,params = "asignatura")
    public List<TemaResponse> getAllTemasByAsignatura(@RequestParam("asignatura") String asignatura){
        return service.getAllTemasByAsignatura(asignatura)
                .stream()
                .map(dto->mapper.map(dto,TemaResponse.class))
                .collect(Collectors.toList());
    }

}
