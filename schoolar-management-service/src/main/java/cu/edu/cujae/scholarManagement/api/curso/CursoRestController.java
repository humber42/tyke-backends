package cu.edu.cujae.scholarManagement.api.curso;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.CursoDto;
import cu.edu.cujae.scholarManagement.service.CursoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.CURSO_URL)
public class CursoRestController {
    @Autowired
    CursoService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<CursoResponse> findAllCursos(){
        return service.findAllCursos().stream().map(dto->mapper.map(dto,CursoResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.CursoUrls.CURSO_GET_ACTIVE)
    public CursoResponse getActiveCurso(){
        return mapper.map(service.getCursoActive(), CursoResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.CursoUrls.CURSO_GET_BY_ID,params = "id")
    public CursoResponse getCursoById(@RequestParam int id){
        return mapper.map(service.getCursoById(id), CursoResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.CursoUrls.CURSO_GET_BY_NAME,params = "name")
    public CursoResponse getCursoByName(@RequestParam String name){
        return mapper.map(service.getCursoByName(name), CursoResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.CursoUrls.CURSO_SAVE)
    public CursoResponse saveCurso(@RequestBody CursoRequest request){
        return mapper.map(service.saveCurso(mapper.map(request,CursoDto.class)), CursoResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.CursoUrls.CURSO_UPDATE)
    public CursoResponse updateCurso(@RequestBody CursoDto dto){
        return mapper.map(service.updateCurso(dto),CursoResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.CursoUrls.CURSO_DELETE_BY_NAME,params = "name")
    public CursoResponse deleteCursoByName(@RequestParam String name){
        return mapper.map(service.deleteCursoByCurso(name), CursoResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.CursoUrls.CURSO_DELETE_BY_ID,params = "id")
    public CursoResponse deleteCursoById(@RequestParam int id){
        return mapper.map(service.deleteCursoById(id), CursoResponse.class);
    }


}
