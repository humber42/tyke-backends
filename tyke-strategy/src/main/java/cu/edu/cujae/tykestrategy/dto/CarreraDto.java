package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class CarreraDto {
    private int id;
    private String nombre;
    private String siglas;
}
