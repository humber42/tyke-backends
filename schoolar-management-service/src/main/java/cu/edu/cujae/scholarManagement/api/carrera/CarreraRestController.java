package cu.edu.cujae.scholarManagement.api.carrera;

import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponse;
import cu.edu.cujae.scholarManagement.api.facultad.FacultadResponseWithoutCarreer;
import cu.edu.cujae.scholarManagement.constants.WebResourceKeyConstants;
import cu.edu.cujae.scholarManagement.dto.CarreraDto;
import cu.edu.cujae.scholarManagement.dto.FacultadDto;
import cu.edu.cujae.scholarManagement.service.CarreraService;
import cu.edu.cujae.scholarManagement.service.FacultadService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(WebResourceKeyConstants.CARRERA_URL)
public class CarreraRestController {
    @Autowired
    CarreraService service;
    @Autowired
    FacultadService facultadService;
    @Autowired
    Mapper mapper;

    @GetMapping
    public List<CarreraResponse> findAllCarreras(){
        return service.findAllCarreras().stream().map(carreraDto ->{
            CarreraResponse response =mapper.map(carreraDto,CarreraResponse.class);
            response.setFacultad(mapper.map(carreraDto.getFacultadByIdFacultad(), FacultadResponseWithoutCarreer.class));
            return response;
            })
                .collect(Collectors.toList());
    }

    @GetMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_BY_ID,params = "id")
    public CarreraResponse getCarreraById(@RequestParam int id){
        CarreraDto dto = service.getCarreraById(id);
        CarreraResponse response = mapper.map(dto, CarreraResponse.class);
        response.setFacultad(mapper.map(dto.getFacultadByIdFacultad(), FacultadResponseWithoutCarreer.class));
        return response;
    }

    @GetMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_BY_NAME,params = "name")
    public CarreraResponse getCarreraByName(@RequestParam String name){
        CarreraDto dto =service.getCarreraByName(name);
        CarreraResponse response = mapper.map(dto, CarreraResponse.class);
        response.setFacultad(mapper.map(dto.getFacultadByIdFacultad(), FacultadResponseWithoutCarreer.class));
        return response;
    }

    @GetMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_BY_SIGLAS,params = "siglas")
    public CarreraResponse getCarreraBySiglas(@RequestParam String siglas){
        CarreraDto dto =service.getCarreraBySiglas(siglas);
        CarreraResponse response = mapper.map(dto, CarreraResponse.class);
        response.setFacultad(mapper.map(dto.getFacultadByIdFacultad(), FacultadResponseWithoutCarreer.class));
        return response;
    }

    @GetMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_FIND_ALL_IN_FACULTY,params = "faculty")
    public List<CarreraResponse> findAllCarreraByFaculty(@RequestParam String faculty){
        return service.findAllCarreraByFacultad(faculty).stream().map(carreraDto -> {
            CarreraResponse response = mapper.map(carreraDto, CarreraResponse.class);
            response.setFacultad(mapper.map(carreraDto.getFacultadByIdFacultad(), FacultadResponseWithoutCarreer.class));
            return response;
        }).collect(Collectors.toList());
    }

    @DeleteMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_DELETE_BY_ID,params = "id")
    public CarreraResponse deleteById(@RequestParam int id){
        CarreraDto dto =service.deleteCarreraById(id);
        CarreraResponse response = mapper.map(dto,CarreraResponse.class);
        response.setFacultad(mapper.map(dto.getFacultadByIdFacultad(),FacultadResponseWithoutCarreer.class));
        return response;
    }

    @DeleteMapping(value = WebResourceKeyConstants.CarreraUrls.CARRERA_DELETE_BY_NAME,params = "name")
    public CarreraResponse deleteByName(@RequestParam String name){
        CarreraDto dto = service.deleteCarreraByName(name);
        CarreraResponse response = mapper.map(dto,CarreraResponse.class);
        response.setFacultad(mapper.map(dto.getFacultadByIdFacultad(),FacultadResponseWithoutCarreer.class));
        return response;
    }

    @PostMapping(WebResourceKeyConstants.CarreraUrls.CARRERA_SAVE)
    public CarreraResponse saveCarrera(@RequestBody CarreraRequest request){
        FacultadDto dto = facultadService.getFacultadByFacultad(request.getFacultad());
        CarreraDto carreraDto = service.saveCarrera(
                CarreraDto.builder()
                        .facultadByIdFacultad(dto)
                        .nombre(request.getNombre())
                        .siglas(request.getSiglas()).build());

        CarreraResponse response = mapper.map(carreraDto,CarreraResponse.class);
        response.setFacultad(mapper.map(carreraDto.getFacultadByIdFacultad(),FacultadResponseWithoutCarreer.class));
        return response;
    }

    @PostMapping(WebResourceKeyConstants.CarreraUrls.CARRERA_UPDATE)
    public CarreraResponse updateCarrera(@RequestBody CarreraResponse request){
        FacultadDto dto = facultadService.getFacultadByFacultad(request.getFacultad().getFacultad());
        CarreraDto carreraDto = mapper.map(request, CarreraDto.class);
        carreraDto.setFacultadByIdFacultad(dto);
        CarreraResponse response = mapper.map(service.updateCarrera( carreraDto),CarreraResponse.class);
        response.setFacultad(mapper.map(carreraDto.getFacultadByIdFacultad(),FacultadResponseWithoutCarreer.class));
        return response;
    }



}
