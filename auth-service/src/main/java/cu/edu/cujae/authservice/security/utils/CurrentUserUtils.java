package cu.edu.cujae.authservice.security.utils;

import cu.edu.cujae.authservice.security.CustomUserDetailsService;
import org.springframework.security.core.context.SecurityContextHolder;

public class CurrentUserUtils {

    private static final String ANONYMOUS_USER = "anonymousUser";

    public CurrentUserUtils() {
        super();
    }

    public static CustomUserDetailsService getUserDetails() {
        return (CustomUserDetailsService) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }

    public static String getUsername() {
        String username = null;
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            username = SecurityContextHolder.getContext().getAuthentication().getName();
        }
        return username;
    }
}
