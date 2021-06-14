package cu.edu.cujae.userservice.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserRoleRequest {

    private Long idUser;
    private Long idRole;

}
