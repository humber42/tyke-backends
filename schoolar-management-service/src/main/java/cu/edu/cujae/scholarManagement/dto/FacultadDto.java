package cu.edu.cujae.scholarManagement.dto;


import lombok.*;
import java.util.Collection;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class FacultadDto {
    private Integer id;
    private String facultad;
    private String siglas;
    private Collection<CarreraDto> carrerasById;
    private Collection<FacultadCursoDto> facultadCursosById;
    private Collection<ProfesorDto> profesorsById;
    private Collection<EstudianteDto> estudianteById;
    private String imagen;
}
