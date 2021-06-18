package cu.edu.cujae.questionservice.dto;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TipoPistaDto {
    private Long id;
    private String tipo;
    private Integer puntosPista;
    private Integer puntosJuego;

}
