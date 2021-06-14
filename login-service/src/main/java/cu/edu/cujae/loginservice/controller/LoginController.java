package cu.edu.cujae.loginservice.controller;

import cu.edu.cujae.loginservice.constants.WebResourceKeyConstants;
import cu.edu.cujae.loginservice.requestDTO.LoginRequest;
import cu.edu.cujae.loginservice.service.LoginService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = WebResourceKeyConstants.BASE_API)
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(value = WebResourceKeyConstants.LOGIN)
    @ApiOperation(value = "This is login api",notes="Request contains username and password")
    public ResponseEntity<String> loginUser(@RequestBody LoginRequest request, HttpServletRequest requestHttp){
        String token = loginService.login(request,requestHttp);
        return ResponseEntity.ok().body(token);
    }

    @GetMapping("/test")
    public String test(){
        return "test done";
    }

}
