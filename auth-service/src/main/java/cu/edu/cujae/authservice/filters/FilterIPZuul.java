package cu.edu.cujae.authservice.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import cu.edu.cujae.authservice.domain.LogsEntity;
import cu.edu.cujae.authservice.ip.service.RequestService;
import cu.edu.cujae.authservice.security.utils.CurrentUserUtils;
import cu.edu.cujae.authservice.service.LogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

public class FilterIPZuul extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(FilterIPZuul.class);

    @Autowired
    RequestService ipService;

    @Autowired
    LogService service;

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String method = request.getMethod();
        String url = request.getRequestURL().toString();
        String ipAdress = ipService.getClientIpAddres(request);
        String username = CurrentUserUtils.getUsername() != null ? CurrentUserUtils.getUsername() : "anonymous";

        logger.info(String.format(
                "%s request to %s with IP Adress: %s, by %s",
                method,
                url,
                ipAdress,
                username
        ));

        LogsEntity entity = new LogsEntity();
        entity.setTypeRequest(method);
        entity.setUrl(url);
        entity.setIpAdress(ipAdress);
        entity.setUsernameEmail(username);
        service.saveLog(entity);

        return null;
    }
}
