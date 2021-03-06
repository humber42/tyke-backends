package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class TipoRegaloDto {
    private Long idTipoRegalo;
    private String nombre;
}
