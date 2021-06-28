package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class EstrategiaPreguntaDto {
    private int id;
    private Long idPregunta;
    private Long idEstrategia;
    private EstrategiaDto estrategiaByIdEstrategia;
}
