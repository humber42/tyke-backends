package cu.edu.cujae.authservice.security;

import cu.edu.cujae.authservice.responseDTO.UserResponse;
import cu.edu.cujae.authservice.feignInterface.UserInterface;
import cu.edu.cujae.authservice.responseDTO.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserInterface userInterface;

    public CustomUserDetailsService(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponse userResponse = userInterface.fetchAdminByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + username + " not found"));

        List<GrantedAuthority> grantedAuthorities = userResponse.getRoles().stream().map(Role::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(String.join("-", username, userResponse.getEmail()),
                userResponse.getPassword(), true, true, true,
                true, grantedAuthorities);
    }
}
