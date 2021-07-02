package cu.edu.cujae.userservice.api;

import cu.edu.cujae.userservice.domain.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest {

    private String username;
    private String fullname;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String lang;
    private String image_url;
    private List<Role> roles;

}
