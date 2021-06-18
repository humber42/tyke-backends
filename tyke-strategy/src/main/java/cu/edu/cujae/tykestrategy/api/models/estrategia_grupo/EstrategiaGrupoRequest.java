package cu.edu.cujae.tykestrategy.api.models.estrategia_grupo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstrategiaGrupoRequest {
    private Long idGrupo;
    private Long idEstrategia;
}
