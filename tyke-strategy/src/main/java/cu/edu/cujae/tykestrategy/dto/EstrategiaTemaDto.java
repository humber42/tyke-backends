package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EstrategiaTemaDto {
    private long idEstrategiaTema;
    private Long idTema;
    private long idEstrategia;
    private TemaDto tema;
}
