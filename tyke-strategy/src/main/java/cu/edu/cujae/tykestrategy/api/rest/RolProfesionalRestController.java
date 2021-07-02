package cu.edu.cujae.tykestrategy.api.rest;

import cu.edu.cujae.tykestrategy.api.models.rol_profesional.RolProfesionalRequest;
import cu.edu.cujae.tykestrategy.api.models.rol_profesional.RolProfessionalResponse;
import cu.edu.cujae.tykestrategy.constants.WebServiceResourceKeyConstants;
import cu.edu.cujae.tykestrategy.dto.RolProfesionalDto;
import cu.edu.cujae.tykestrategy.service.RolProfesionalService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
@RestController
@RequestMapping(WebServiceResourceKeyConstants.ROL_PROFESIONAL_API)
public class RolProfesionalRestController {

    @Autowired
    RolProfesionalService service;
    @Autowired
    Mapper mapper;

    @GetMapping(WebServiceResourceKeyConstants.Endpoints.GET_ALL)
    public List<RolProfesionalDto> getAllRolProfesional(){
        return service.findAllRolProfesional();
    }

    @GetMapping(value = WebServiceResourceKeyConstants.Endpoints.GET_BY_ID, params = "id")
    public RolProfessionalResponse getRolProfesionalByID(@RequestParam("id") long id){
        return service.getRolProfesionalById(id)
                .map(entity->mapper.map(entity,RolProfessionalResponse.class))
                .get();
    }

    @DeleteMapping(value = WebServiceResourceKeyConstants.Endpoints.DELETE_BY_ID,params = "id")
    public void deleteRolProfesionalByID(@RequestParam("id") long id){
        service.deleteRolProfesionalById(id);
    }

    @DeleteMapping(WebServiceResourceKeyConstants.Endpoints.DELETE)
    public void deleteRolProfesional(@RequestBody RolProfessionalResponse request){
        service.deleteRolProfesional(mapper.map(request, RolProfesionalDto.class));
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.SAVE)
    public RolProfesionalDto saveRolProfesional(@RequestBody RolProfesionalRequest request){
        return service.saveRolProfesional(mapper.map(request, RolProfesionalDto.class))
                .get();
    }

    @PostMapping(WebServiceResourceKeyConstants.Endpoints.UPDATE)
    public RolProfessionalResponse updateRolProfesional(@RequestBody RolProfessionalResponse request){
        return service.updateRolProfesional(mapper.map(request, RolProfesionalDto.class))
                .map(entity->mapper.map(entity,RolProfessionalResponse.class))
                .get();
    }
}
