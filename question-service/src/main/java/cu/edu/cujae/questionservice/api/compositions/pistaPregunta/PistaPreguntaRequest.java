package cu.edu.cujae.questionservice.api.compositions.pistaPregunta;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaPreguntaRequest {
    private Long idPregunta;
    private Long idPista;
}
