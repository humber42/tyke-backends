package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class EstrategiaGrupoDto {
    private long idEstrategiaGrupo;
    private Long idGrupo;
    private Long idEstrategia;
    private GrupoDto grupo;
}
