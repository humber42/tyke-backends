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
    private long id;
    private String texto;
    private Integer puntuacion;
    private Boolean correcta;
    private Integer orden;
    private String textoEnlazar;
    private Long idPregunta;
    private Collection<ProfileRespuestaPreguntaDto> profileRespuestaPreguntasById;
    private PreguntaDto preguntaByIdPregunta;
}
