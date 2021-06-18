package cu.edu.cujae.tykestrategy.api.models.regalo;

import cu.edu.cujae.tykestrategy.api.models.otorgamiento.OtorgamientoResponse;
import cu.edu.cujae.tykestrategy.api.models.tipo_regalo.TipoRegaloResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegaloResponse {
    private long idRegalo;
    private String descripcion;

    private TipoRegaloResponse tipoRegalo;
    private OtorgamientoResponse otorgamiento;
}
