package cu.edu.cujae.userservice.api;

import cu.edu.cujae.userservice.domain.Role;
import lombok.*;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {

    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String lang;
    private List<Role> roles;
    private Integer loginAttempt;
    private String status;

    private String image_url;

}
