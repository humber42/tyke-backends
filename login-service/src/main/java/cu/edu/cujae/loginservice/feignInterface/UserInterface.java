package cu.edu.cujae.loginservice.feignInterface;


import cu.edu.cujae.loginservice.constants.MicroServiceConstants;
import cu.edu.cujae.loginservice.requestDTO.UserRequest;
import cu.edu.cujae.loginservice.responseDTO.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = MicroServiceConstants.UserMicroserviceConstants.BASE)
@Service
@RequestMapping(value = MicroServiceConstants.BASE_API)
public interface UserInterface {

    @RequestMapping(value = MicroServiceConstants.UserMicroserviceConstants.SEARCH_USER)
    UserResponse searchUser(@RequestBody UserRequest request);

    @RequestMapping(value = MicroServiceConstants.UserMicroserviceConstants.UPDATE_USER)
    void updateUser(@RequestBody UserResponse userResponse);

    @RequestMapping(value = MicroServiceConstants.UserMicroserviceConstants.FETCH_BY_USERNAME)
    UserResponse searchByUsername(@PathVariable(value = "username") String username);


}
