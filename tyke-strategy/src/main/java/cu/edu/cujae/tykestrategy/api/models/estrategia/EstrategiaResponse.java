package cu.edu.cujae.tykestrategy.api.models.estrategia;

import cu.edu.cujae.tykestrategy.api.models.estrategia_grupo.EstrategiaGrupoResponse;
import cu.edu.cujae.tykestrategy.api.models.estrategia_tema.EstrategiaTemaResponse;
import cu.edu.cujae.tykestrategy.api.models.jugador_desafio.JugadorDesafioWithoutEstrategia;
import cu.edu.cujae.tykestrategy.api.models.jugador_estrategia.JugadorEstrategiaResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.Collection;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstrategiaResponse {
    private long idEstrategia;
    private Integer puntos;
    private String nombre;
    private Date fechaCreacion;
    private Long idProfesor;
    private Boolean habilitada;
    private Boolean evaluada;

    private Collection<EstrategiaGrupoResponse> grupos;
    private Collection<EstrategiaTemaResponse> temas;
    private Collection<JugadorDesafioWithoutEstrategia> desafios;
    private Collection<JugadorEstrategiaResponse> jugadores;
}
