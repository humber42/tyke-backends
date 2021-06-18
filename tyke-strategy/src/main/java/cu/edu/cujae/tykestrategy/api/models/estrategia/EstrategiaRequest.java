package cu.edu.cujae.tykestrategy.api.models.estrategia;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EstrategiaRequest {
    private Integer puntos;
    private String nombre;
    private Date fechaCreacion;
    private Long idProfesor;
    private Boolean habilitada;
    private Boolean evaluada;
}
