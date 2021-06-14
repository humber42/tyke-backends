package cu.edu.cujae.loginservice.service;

import cu.edu.cujae.loginservice.requestDTO.LoginRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface LoginService {

    String login(LoginRequest requesLogin, HttpServletRequest request);
}
