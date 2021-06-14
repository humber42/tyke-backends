package cu.edu.cujae.scholarManagement.api.carrera;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarreraRequest {
    private String nombre;
    private String siglas;
    private String facultad;
}
