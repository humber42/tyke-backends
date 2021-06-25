package cu.edu.cujae.questionservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class BonificacionPreguntaTiempoDto {
    private long id;
    private Long idPregunta;
    private Long tiempoMenor;
    private Integer bonificacion;
    private PreguntaDto preguntaByIdPregunta;
}
