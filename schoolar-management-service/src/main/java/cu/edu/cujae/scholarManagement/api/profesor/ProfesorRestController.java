package cu.edu.cujae.scholarManagement.api.profesor;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.ProfesorDto;
import cu.edu.cujae.scholarManagement.service.ProfesorService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.PROFESOR_URL)
public class ProfesorRestController {

    @Autowired
    ProfesorService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<ProfesorResponse> getAllProfesors(){
        return service.findAllProfesors().stream().map(dto -> mapper.map(dto,ProfesorResponse.class)).collect(Collectors.toList());
    }



    @GetMapping(value = WebResourceKeyConstants.ProfesorUrls.PROFESOR_GET_BY_ID,params = "id")
    public ProfesorResponse getProfesorById(@RequestParam int id){
        return mapper.map(service.getProfesorById(id), ProfesorResponse.class);
    }


    @PostMapping(WebResourceKeyConstants.ProfesorUrls.PROFESOR_SAVE)
    public ProfesorResponse saveProfesor(@RequestBody ProfesorRequest request){
        return mapper.map(service.saveProfesor(mapper.map(request, ProfesorDto.class)), ProfesorResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.ProfesorUrls.PROFESOR_UPDATE)
    public ProfesorResponse updateProfesor(@RequestBody ProfesorResponse response){
        return mapper.map(service.updateProfesor(mapper.map(response,ProfesorDto.class)), ProfesorResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.ProfesorUrls.PROFESOR_DELETE_BY_ID,params = "id")
    public ProfesorResponse deleteById(@RequestParam int id){
        return mapper.map(service.deleteById(id), ProfesorResponse.class);
    }



}
