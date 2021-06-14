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
public class AnnoGrupoDto {
    private Integer idAnno;
    private Integer idGrupo;
    private AnnoDto annoByIdAnno;
    private GrupoDto grupoByIdGrupo;





}
