package cu.edu.cujae.scholarManagement.api.facultad;


import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.FacultadDto;
import cu.edu.cujae.scholarManagement.service.FacultadService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.FACULTAD_URL)
public class FacultadRestController {

    @Autowired
    FacultadService service;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<FacultadResponse> findAllFaculties(){
        return service.findAllFaculties().stream().map(facultadDto -> mapper.map(facultadDto,FacultadResponse.class)).collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.FacultadUrls.FACULTAD_GET_BY_ID,params = "id")
    public FacultadResponse getFacultadById(@RequestParam int id){
        return mapper.map(service.getFacultadById(id), FacultadResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.FacultadUrls.FACULTAD_GET_BY_NAME,params = "name")
    public FacultadResponse getFacultadByName(@RequestParam String name){
        return mapper.map(service.getFacultadByFacultad(name), FacultadResponse.class);
    }

    @GetMapping(value = WebResourceKeyConstants.FacultadUrls.FACULTAD_GET_BY_SIGLAS,params = "siglas")
    public FacultadResponse getFacultadBySiglas(@RequestParam String siglas){
        return mapper.map(service.getFacultadBySiglas(siglas), FacultadResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.FacultadUrls.FACUlTAD_SAVE)
    public FacultadResponse saveFacultad(@RequestBody FacultadRequest request){
        return mapper.map(service.saveFacultad(FacultadDto.builder().
                facultad(request.getFacultad())
                .siglas(request.getSiglas())
                .build()), FacultadResponse.class);
    }

    @PostMapping(WebResourceKeyConstants.FacultadUrls.FACULTAD_UPDATE)
    public FacultadResponse updateFacultad(@RequestBody FacultadResponse request){
        FacultadDto resposnse = mapper.map(request, FacultadDto.class);
        FacultadResponse respuesta = mapper.map(service.updateFacultad(resposnse), FacultadResponse.class);
        return respuesta;
    }

    @DeleteMapping(value = WebResourceKeyConstants.FacultadUrls.FACULTAD_DELETE_BY_ID,params = "id")
    public FacultadResponse deleteById(@RequestParam int id){
        return mapper.map(service.deleteFacultadById(id), FacultadResponse.class);
    }

    @DeleteMapping(value = WebResourceKeyConstants.FacultadUrls.FACULTAD_DELETE_BY_NAME,params = "name")
    public FacultadResponse deleteByFaculty(@RequestParam String name){
        return mapper.map(service.deleteFacultadByName(name), FacultadResponse.class);
    }

}
