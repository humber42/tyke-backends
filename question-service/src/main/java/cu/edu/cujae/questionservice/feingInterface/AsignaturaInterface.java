package cu.edu.cujae.questionservice.feingInterface;


import cu.edu.cujae.questionservice.constants.MicroserviceConstants;
import cu.edu.cujae.questionservice.dto.AsignaturaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static cu.edu.cujae.questionservice.constants.MicroserviceConstants.BASE_API_ASIGNATURA;
import static cu.edu.cujae.questionservice.constants.MicroserviceConstants.SchoolarManagementConstants.BASE;

@FeignClient(name = BASE)
@Service
@RequestMapping(value = BASE_API_ASIGNATURA)
public interface AsignaturaInterface {

    @RequestMapping(method = RequestMethod.GET)
    List<AsignaturaDto> getAllAsign();

    @GetMapping(value = MicroserviceConstants.SchoolarManagementConstants.FETCH_BY_NAME)
    AsignaturaDto fetchByAsignaturaName(@PathVariable("name") String name);
}
