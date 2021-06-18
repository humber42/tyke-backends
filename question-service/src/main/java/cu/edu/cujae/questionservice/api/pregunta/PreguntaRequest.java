package cu.edu.cujae.questionservice.api.pregunta;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PreguntaRequest {

    private String tituloPregunta;
    private long idTipoPregunta;
    private String asignatura;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
}
