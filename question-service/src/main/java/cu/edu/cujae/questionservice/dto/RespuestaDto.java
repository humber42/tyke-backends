package cu.edu.cujae.questionservice.dto;

import lombok.*;

import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@EqualsAndHashCode
public class RespuestaDto {
    private Long id;
    private String texto;
    private Integer puntuación;
    private Collection<PreguntaRespuestaDto> preguntaRespuestasById;
}
