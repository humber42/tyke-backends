package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaTemaDto {
    private Integer idAsignatura;
    private Integer idTema;
    private AsignaturaDto asignaturaByIdAsignatura;
    private TemaDto temaByIdTema;






}
