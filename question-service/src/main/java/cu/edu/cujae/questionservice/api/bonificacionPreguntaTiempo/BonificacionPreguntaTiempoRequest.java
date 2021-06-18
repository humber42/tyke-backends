package cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BonificacionPreguntaTiempoRequest {
    private Long tiempoMenor;
    private Integer bonificacion;
    private long idPregunta;
}
