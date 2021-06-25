package cu.edu.cujae.questionservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProfileRespuestaPreguntaDto {
    private long id;
    private Long idRespuesta;
    private Long idPregunta;
    private Integer tiempoSegundos;
    private String username;
    private RespuestaDto respuestaByIdRespuesta;
    private PreguntaDto preguntaByIdPregunta;
    private UserDto userDto;
}
