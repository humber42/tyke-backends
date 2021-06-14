package cu.edu.cujae.userservice.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {
    private Long id;
    private String roleName;
    private String description;


}
