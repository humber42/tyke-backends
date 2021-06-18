package cu.edu.cujae.scholarManagement.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UsuarioDto {
    Long id;
    String username;
    String email;
    String fullname;
    String gender;
}
