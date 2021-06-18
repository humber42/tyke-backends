package cu.edu.cujae.tykestrategy.feignInterface;

import cu.edu.cujae.tykestrategy.constants.MicroservicesConstants;
import cu.edu.cujae.tykestrategy.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = MicroservicesConstants.UserMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroservicesConstants.BASE_USER_API)
public interface UserInterface {

    @RequestMapping(value = MicroservicesConstants.UserMicroserviceConstants.FECTH_USER_BY_ID)
    UserDto searchById(@PathVariable("id") int id);
}
