package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class TemaDto {
    private Integer id;
    private String nombre;
    private String description;
    private Collection<AsignaturaTemaDto> asignaturaTemasById;


}
