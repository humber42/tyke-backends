package cu.edu.cujae.questionservice.feingInterface;

import cu.edu.cujae.questionservice.constants.MicroserviceConstants;
import cu.edu.cujae.questionservice.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = MicroserviceConstants.UserMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroserviceConstants.BASE_API_USER)
public interface UserInterface {

    @RequestMapping(value = MicroserviceConstants.UserMicroserviceConstants.FETCH_USER_BY_ID)
    UserDto searchById(@PathVariable("username") String username);

}
