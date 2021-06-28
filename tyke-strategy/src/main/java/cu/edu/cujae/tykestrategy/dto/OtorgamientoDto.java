package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class OtorgamientoDto {
    private long idOtorgamiento;
    private Integer cantPuntos;
    private String otorgamiento;
}
