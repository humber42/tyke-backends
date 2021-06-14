package cu.edu.cujae.scholarManagement.dto;

import lombok.*;

import java.util.Collection;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class AsignaturaDto {
    private Integer id;
    private String nombre;
    private Boolean activo;
    private Collection<AsignaturaProfesorEstudianteDto> asignaturaProfesorEstudiantesById;
    private Collection<AsignaturaTemaDto> asignaturaTemasById;
    private Collection<SemestreAsignaturaDto> semestreAsignaturasById;
    private Collection<SignatureCarreraDto> signatureCarreraById;






}
