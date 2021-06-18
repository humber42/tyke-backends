package cu.edu.cujae.questionservice.dto;


import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class PistaDto {
    private Long id;
    private String textoAyuda;
    private long idTipoPista;
    private TipoPistaDto tipoPistaByIdTipoPista;
}
