package cu.edu.cujae.tykenotifications.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class User {
    private String username;
    private String email;
}
