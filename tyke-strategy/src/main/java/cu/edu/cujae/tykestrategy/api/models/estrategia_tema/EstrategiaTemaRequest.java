package cu.edu.cujae.tykestrategy.api.models.estrategia_tema;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstrategiaTemaRequest {
    private Long idTema;
    private long idEstrategia;
}
