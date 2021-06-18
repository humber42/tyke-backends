package cu.edu.cujae.questionservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class ProfileRespuestaPreguntaDto {
    private Long id;
    private UserDto userDto;
    private String username;
    private Integer tiempoSegundos;
    private long idRespuesta;
    private long idPregunta;
    private RespuestaDto respuestaByIdRespuesta;
    private PreguntaDto preguntaByIdPregunta;
}
