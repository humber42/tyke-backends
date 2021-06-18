package cu.edu.cujae.questionservice.ip.service;

import javax.servlet.http.HttpServletRequest;

public interface RequestService {

    String getClientIpAddres(HttpServletRequest request);

}
