package cu.edu.cujae.questionservice.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PistaDto {
    private long id;
    private String textoAyuda;
    private int idTipoPista;
    private Long idPregunta;
    private TipoPistaDto tipoPistaByIdTipoPista;
    private PreguntaDto preguntaByIdPregunta;
}
