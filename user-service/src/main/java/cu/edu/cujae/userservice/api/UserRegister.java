package cu.edu.cujae.userservice.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRegister {

    private String username;
    private String fullname;
    private String password;
    private String email;
	private String faculty;

}
