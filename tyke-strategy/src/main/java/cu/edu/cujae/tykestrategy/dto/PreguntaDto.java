package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode
public class PreguntaDto {
    private long id;
    private String tituloPregunta;
}
