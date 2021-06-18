package cu.edu.cujae.questionservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class BonificacionPreguntaTiempoDto {
    private Long id;
    private Long tiempoMenor;
    private Integer bonificacion;
    private long idPregunta;
    private PreguntaDto preguntaByIdPregunta;
}
