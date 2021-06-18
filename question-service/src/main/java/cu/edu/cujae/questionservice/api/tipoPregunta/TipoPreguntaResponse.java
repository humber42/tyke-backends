package cu.edu.cujae.questionservice.api.tipoPregunta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TipoPreguntaResponse {
    private Long id;
    private String tipo;
}
