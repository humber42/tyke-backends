package cu.edu.cujae.tykestrategy.api.models.tipo_regalo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoRegaloRequest {
    private String nombre;
}
