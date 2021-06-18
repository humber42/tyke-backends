package cu.edu.cujae.tykestrategy.api.models.otorgamiento;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OtorgamientoResponse {
    private long idOtorgamiento;
    private Integer cantPuntos;
    private String otorgamiento;
}
