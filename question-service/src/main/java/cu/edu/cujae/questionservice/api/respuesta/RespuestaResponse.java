package cu.edu.cujae.questionservice.api.respuesta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespuestaResponse {
    private Long id;
    private String texto;
    private Integer puntuación;

}
