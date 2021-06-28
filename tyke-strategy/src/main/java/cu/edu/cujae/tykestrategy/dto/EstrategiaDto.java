package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

import java.sql.Date;
import java.util.Collection;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Builder
public class EstrategiaDto {
    private long idEstrategia;
    private Integer puntos;
    private String nombre;
    private Date fecha;
    private Long idProfesor;
    private ProfesorDto profesor;
    private Boolean habilitada;
    private Boolean evaluada;
    private Collection<EstrategiaGrupoDto> grupos;
    private Collection<EstrategiaTemaDto> temas;
    private Collection<JugadorDesafioDto> desafios;
    private Collection<JugadorEstrategiaDto> jugadores;
    private Collection<EstrategiaPreguntaDto> estrategiaPreguntasByIdEstrategia;

}
