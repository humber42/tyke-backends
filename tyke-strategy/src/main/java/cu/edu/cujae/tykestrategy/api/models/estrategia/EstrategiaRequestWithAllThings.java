package cu.edu.cujae.tykestrategy.api.models.estrategia;

import cu.edu.cujae.tykestrategy.dto.GrupoDto;
import cu.edu.cujae.tykestrategy.dto.PreguntaDto;
import cu.edu.cujae.tykestrategy.dto.TemaDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class EstrategiaRequestWithAllThings {

    private String nombre;
    private int cantPuntos;
    private boolean habilitada;
    private boolean evaluada;
    private List<TemaDto> temas;
    private List<GrupoDto> grupos;
    private List<PreguntaDto> pregunta;
    private long idProfesor;

}
