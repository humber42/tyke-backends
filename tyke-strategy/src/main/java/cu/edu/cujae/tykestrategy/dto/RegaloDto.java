package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RegaloDto {
    private long idRegalo;
    private long idTipoRegalo;
    private long idOtorgamiento;
    private String descripcion;
    //private Collection<JugadorRegaloEntity> jugadorRegalos;
    private TipoRegaloDto tipoRegalo;
    private OtorgamientoDto otorgamiento;
}
