package cu.edu.cujae.questionservice.api.pregunta;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaRequest {
    private String tituloPregunta;
    private Long idTipoPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;
}
