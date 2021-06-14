package cu.edu.cujae.scholarManagement.api.tema;

import cu.edu.cujae.scholarManagement.api.compositions.asignatura_tema.AsignaturaTemaResponse;

import lombok.*;

import java.util.Collection;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TemaResponse {
    private Integer id;
    private String nombre;
    private String description;
    private Collection<AsignaturaTemaResponse> asignaturaTemasById;
}
