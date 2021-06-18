package cu.edu.cujae.tykestrategy.api.models.insignia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InsigniaRequest {
    private String nombre;
    private Integer puntosAvance;
    private Integer puntosOtorgar;
    private long idRolProfesional;
}
