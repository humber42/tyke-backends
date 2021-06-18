package cu.edu.cujae.tykestrategy.api.models.estrategia_grupo;

import cu.edu.cujae.tykestrategy.dto.GrupoDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class EstrategiaGrupoResponse {
    private GrupoDto grupo;
}
