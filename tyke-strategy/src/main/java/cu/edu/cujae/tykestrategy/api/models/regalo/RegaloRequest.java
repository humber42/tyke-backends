package cu.edu.cujae.tykestrategy.api.models.regalo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegaloRequest {
    private long idTipoRegalo;
    private long idOtorgamiento;
    private String descripcion;
}
