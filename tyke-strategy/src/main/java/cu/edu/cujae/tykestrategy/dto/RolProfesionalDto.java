package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class RolProfesionalDto {
    private long idRolProfesional;
    private Long idCarrera;
    private Long idTema;
    private String nombre;
    private TemaDto tema;
    private CarreraDto carrera;
}
