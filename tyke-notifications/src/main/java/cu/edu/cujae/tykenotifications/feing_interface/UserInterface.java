package cu.edu.cujae.tykenotifications.feing_interface;


import cu.edu.cujae.tykenotifications.constants.MicroserviceConstants;
import cu.edu.cujae.tykenotifications.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = MicroserviceConstants.UserMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroserviceConstants.BASE_API_USER)
public interface UserInterface {

    @RequestMapping(value = MicroserviceConstants.UserMicroserviceConstants.FETCH_USER_BY_ID)
    User searchById(@PathVariable("id") long id);

}
