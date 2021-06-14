package cu.edu.cujae.authservice.responseDTO;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author smriti on 6/27/19
 */

@Getter
@Setter
public class UserResponse implements Serializable{

    private Long id;

    private String username;
    private String fullname;

    private String email;

    private String password;
    private Date dob;

    private String status;

    private Integer loginAttempt;

    private List<Role> roles = new ArrayList<>();
}
