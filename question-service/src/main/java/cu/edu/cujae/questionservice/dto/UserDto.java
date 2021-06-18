package cu.edu.cujae.questionservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class UserDto {
    private String username;
    private String fullname;
    private String email;
}
