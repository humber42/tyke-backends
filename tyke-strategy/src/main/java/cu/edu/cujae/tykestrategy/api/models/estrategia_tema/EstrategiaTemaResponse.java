package cu.edu.cujae.tykestrategy.api.models.estrategia_tema;

import cu.edu.cujae.tykestrategy.dto.TemaDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstrategiaTemaResponse {
    private TemaDto tema;
}
