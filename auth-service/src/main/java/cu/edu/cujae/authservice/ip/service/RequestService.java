package cu.edu.cujae.authservice.ip.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {

    String getClientIpAddres(HttpServletRequest request);

}
