package cu.edu.cujae.tykestrategy.api.models.estrategia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EstrategiaResponseWithoutCollection {
    private long idEstrategia;
    private Integer puntos;
    private String nombre;
    private Date fecha;
    private Long idProfesor;
    private Boolean habilitada;
    private Boolean evaluada;
}
