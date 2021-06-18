package cu.edu.cujae.questionservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TipoPreguntaDto {
    private Long id;
    private String tipo;
}
