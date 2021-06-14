package cu.edu.cujae.userservice.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SaveStudent {
    private int id_facultad;
    private int id_usuario;
}
