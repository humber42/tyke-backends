package cu.edu.cujae.scholarManagement.api.semestre;


import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.SemestreDto;
import cu.edu.cujae.scholarManagement.service.SemestreService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.SEMESTRE_URL)
public class SemestreRestController {
    @Autowired
    SemestreService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<SemestreResponse> findAllSemestre(){
        return service.findAllSemestre().stream().map(dto -> mapper.map(dto,SemestreResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(WebResourceKeyConstants.SemestreUrls.SEMESTRE_GET_ACTIVE)
    public SemestreResponse getActiveSemestre(){
        return mapper.map(service.getActiveSemestre(), SemestreResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.SemestreUrls.SEMESTRE_GET_BY_ID,params = "id")
    public SemestreResponse getById(@RequestParam int id){
        return mapper.map(service.getSemestreById(id), SemestreResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.SemestreUrls.SEMESTRE_GET_BY_NAME,params = "name")
    public SemestreResponse getByName(@RequestParam String name){
        return mapper.map(service.getSemestreByName(name), SemestreResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.SemestreUrls.SEMESTRE_SAVE)
    public SemestreResponse saveSemestre(@RequestBody SemestreRequest request){
        return mapper.map(service.saveSemestre(mapper.map(request, SemestreDto.class)), SemestreResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.SemestreUrls.SEMESTRE_UPDATE)
    public SemestreResponse updateSemestre(@RequestBody SemestreResponse request){
        return mapper.map(service.updateSemestreDto(mapper.map(request, SemestreDto.class)), SemestreResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.SemestreUrls.SEMESTRE_DELETE_BY_ID,params = "id")
    public SemestreResponse deleteById(@RequestParam int id){
        return mapper.map(service.deleteById(id), SemestreResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.SemestreUrls.SEMESTRE_DELETE_BY_NAME,params = "name")
    public SemestreResponse deleteByName(@RequestParam String name){
        return mapper.map(service.deleteBySemestreName(name), SemestreResponse.class);
    }

}
