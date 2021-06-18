package cu.edu.cujae.questionservice.api.respuesta;

import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class RespuestaResponseWithoutCollections {
    private Long id;
    private String texto;
    private Integer puntuación;

}
