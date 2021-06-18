package cu.edu.cujae.tykestrategy.dto;


import lombok.*;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InsigniaDto {
    private long idInsignia;
    private String nombre;
    private Integer puntosAvance;
    private Integer puntosOtorgar;
    private long idRolProfesional;
    private RolProfesionalDto rolProfesional;
    //private Collection<JugadorInsigniaEntity> jugadores;
}
