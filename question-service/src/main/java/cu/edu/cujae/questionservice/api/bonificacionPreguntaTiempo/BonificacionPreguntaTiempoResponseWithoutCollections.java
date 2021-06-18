package cu.edu.cujae.questionservice.api.bonificacionPreguntaTiempo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BonificacionPreguntaTiempoResponseWithoutCollections {
    private Long id;
    private Long tiempoMenor;
    private Integer bonificacion;
}
