package cu.edu.cujae.authservice.responseDTO;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Role {

    private Long id;
    private String roleName;
}
