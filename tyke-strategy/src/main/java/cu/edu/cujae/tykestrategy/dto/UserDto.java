package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class UserDto {
    private String username;
    private String email;
}
