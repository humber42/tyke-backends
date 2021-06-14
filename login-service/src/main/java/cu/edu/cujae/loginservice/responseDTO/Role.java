package cu.edu.cujae.loginservice.responseDTO;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role implements Serializable {

    private int id;
    private String roleName;
}
