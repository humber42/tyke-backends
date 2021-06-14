package cu.edu.cujae.authservice.feignInterface;

import cu.edu.cujae.authservice.responseDTO.UserResponse;
import cu.edu.cujae.authservice.constants.MicroServiceConstants;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@FeignClient(name = MicroServiceConstants.USER_MICROSERVICE)
@Service
@RequestMapping(value = MicroServiceConstants.BASE_API)
public interface UserInterface {

    @RequestMapping(value = MicroServiceConstants.UserMicroServiceConstants.FETCH_USER_USERNAME)
    Optional<UserResponse> fetchAdminByUsername(@PathVariable("username") String username);
}
