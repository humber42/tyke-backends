package cu.edu.cujae.questionservice.api.pista;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PistaRequestForQuestion {
    private String pistaName;
    private String tipoPistaSelected;
}
