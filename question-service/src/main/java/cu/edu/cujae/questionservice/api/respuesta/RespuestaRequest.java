package cu.edu.cujae.questionservice.api.respuesta;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class RespuestaRequest {
    private String texto;
    private Integer puntuacion;
    private Boolean correcta;
    private Integer orden;
    private String textoEnlazar;
    private Long idPregunta;
}
