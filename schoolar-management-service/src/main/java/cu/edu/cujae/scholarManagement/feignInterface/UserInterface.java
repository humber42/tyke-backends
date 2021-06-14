package cu.edu.cujae.scholarManagement.feignInterface;

import cu.edu.cujae.scholarManagement.constants.MicroserviceConstantsResource;
import cu.edu.cujae.scholarManagement.dto.UsuarioDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = MicroserviceConstantsResource.UserMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroserviceConstantsResource.BASE_API_USER)
public interface UserInterface {

    @RequestMapping(value = MicroserviceConstantsResource.UserMicroserviceConstants.FETCH_USER_BY_ID)
    UsuarioDto searchById(@PathVariable("id") int id);
}
