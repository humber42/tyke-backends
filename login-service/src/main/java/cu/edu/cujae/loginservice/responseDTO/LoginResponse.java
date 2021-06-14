package cu.edu.cujae.loginservice.responseDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponse implements Serializable {
    private String token;
}
