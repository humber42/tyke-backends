package cu.edu.cujae.loginservice.requestDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequest implements Serializable {
    private String username;
    private String email;
}
