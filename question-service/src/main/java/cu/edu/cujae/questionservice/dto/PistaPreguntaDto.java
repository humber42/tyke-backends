package cu.edu.cujae.questionservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PistaPreguntaDto {
    private Long idPregunta;
    private Long idPista;
    private PreguntaDto preguntaByIdPregunta;
    private PistaDto pistaByIdPista;
}
