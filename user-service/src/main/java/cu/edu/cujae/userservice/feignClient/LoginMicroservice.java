package cu.edu.cujae.userservice.feignClient;

import cu.edu.cujae.userservice.constants.MicroserviceConstantService;
import cu.edu.cujae.userservice.domain.LoginClass;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(MicroserviceConstantService.LoginMicroservice.BASE)
@Service
@RequestMapping(MicroserviceConstantService.BASE_API_LOGIN)
public interface LoginMicroservice {

    @RequestMapping(value = MicroserviceConstantService.LoginMicroservice.LOGIN)
    String login(@RequestBody LoginClass login);
}
