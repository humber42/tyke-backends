package cu.edu.cujae.tykestrategy.api.models.regalo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegaloRequestWithId {

        private String idTipoRegalo;
        private String idOtorgamiento;
        private String descripcion;
        private long idRegalo;
}
