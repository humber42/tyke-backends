package cu.edu.cujae.scholarManagement.api.estudiante;

import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.EstudianteDto;
import cu.edu.cujae.scholarManagement.service.EstudianteService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.ESTUDIANTE_URL)
public class EstudianteRestController {

    @Autowired
    Mapper mapper;

    @Autowired
    EstudianteService service;

    @GetMapping
    public List<EstudianteResponse> findAllEstudiantes(){
        return service.findAllEstudents().stream().map(
                estudianteDto -> mapper.map(estudianteDto,EstudianteResponse.class)
        ).collect(Collectors.toList());
    }



    @GetMapping(value = WebResourceKeyConstants.EstudianteUrls.ESTUDIANTE_GET_BY_ID,params = "id")
    public EstudianteResponse getById(@RequestParam int id){
        return mapper.map(service.getEstudianteById(id), EstudianteResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.EstudianteUrls.ESTUDIANTE_SAVE)
    public EstudianteResponse saveEstudiante(@RequestBody EstudianteRequest request){
        return mapper.map(
                service.saveEstudiante(mapper.map(request, EstudianteDto.class)), EstudianteResponse.class
        );
    }

    @PostMapping(WebResourceKeyConstants.EstudianteUrls.ESTUDIANTE_UPDATE)
    public EstudianteResponse updateEstudiante(EstudianteResponse response){
        return mapper.map(
                service.updateEstudiante(mapper.map(response, EstudianteDto.class)), EstudianteResponse.class
        );
    }

    @DeleteMapping(value = WebResourceKeyConstants.EstudianteUrls.ESTUDIANTE_DELETE_BY_ID,params = "id")
    public EstudianteResponse deleteById(@RequestParam int id){
        return mapper.map(service.deleteEstudianteById(id), EstudianteResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.EstudianteUrls.ESTUDIANTE_FETCH_ALL_BY_FACULTY,params = "nameFaculty")
    public List<EstudianteResponse> fecthAllByFaculty(@RequestParam("nameFaculty") String nameFaculty){
        return service.getAllStudentsByFacultad(nameFaculty)
                .stream()
                .map(entity->mapper.map(entity,EstudianteResponse.class))
                .collect(Collectors.toList());
    }
}
