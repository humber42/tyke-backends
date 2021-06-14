package cu.edu.cujae.loginservice.requestDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequest implements Serializable {
    private String userCredential;
    private String password;
}
