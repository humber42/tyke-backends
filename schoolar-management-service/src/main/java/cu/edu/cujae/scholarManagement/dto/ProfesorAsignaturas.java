package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProfesorAsignaturas {

    private int idProfesor;
    private List<String> asignaturas;

}
