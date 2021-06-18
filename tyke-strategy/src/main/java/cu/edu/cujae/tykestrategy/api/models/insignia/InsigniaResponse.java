package cu.edu.cujae.tykestrategy.api.models.insignia;

import cu.edu.cujae.tykestrategy.api.models.rol_profesional.RolProfessionalResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsigniaResponse {
    private long idInsignia;
    private String nombre;
    private Integer puntosAvance;
    private Integer puntosOtorgar;
    private RolProfessionalResponse rolProfesional;
}
