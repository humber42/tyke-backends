package cu.edu.cujae.userservice.feignClient;

import cu.edu.cujae.userservice.constants.MicroserviceConstantService;
import cu.edu.cujae.userservice.domain.FacultadDto;
import cu.edu.cujae.userservice.domain.SaveStudent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(MicroserviceConstantService.SchoolarMicroservice.BASE)
@Service
@RequestMapping(MicroserviceConstantService.BASE_API_SCHOOLAR)
public interface SchoolarMicroservice {

    @GetMapping(value = MicroserviceConstantService.SchoolarMicroservice.GET_FACULTY_NAME,params = "name")
    FacultadDto getFacultyByName(@RequestParam("name") String name);

    @RequestMapping(MicroserviceConstantService.SchoolarMicroservice.SAVE_STUDENT)
    void saveStudent(@RequestBody SaveStudent student);


}
