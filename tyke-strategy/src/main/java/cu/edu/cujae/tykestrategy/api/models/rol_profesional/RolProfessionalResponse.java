package cu.edu.cujae.tykestrategy.api.models.rol_profesional;

import cu.edu.cujae.tykestrategy.dto.CarreraDto;
import cu.edu.cujae.tykestrategy.dto.TemaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RolProfessionalResponse {
    private long idRolProfesional;
    private String nombre;
    private TemaDto tema;
    private CarreraDto carrera;
}
