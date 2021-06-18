package cu.edu.cujae.scholarManagement.api.facultad;

import cu.edu.cujae.scholarManagement.api.carrera.CarreraResponseWhithoutFaculty;
import cu.edu.cujae.scholarManagement.dto.EstudianteDto;
import lombok.*;

import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultadResponse {
    private int id;
    private String facultad;
    private String siglas;
    private Collection<CarreraResponseWhithoutFaculty> carrerasById;
    private Collection<EstudianteDto> estudianteById;
    private String imagen;

}
