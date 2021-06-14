package cu.edu.cujae.loginservice.responseDTO;

import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse implements Serializable {
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
    private String  status;
}
