package cu.edu.cujae.questionservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TipoPreguntaDto {
    private long id;
    private String tipo;
}
