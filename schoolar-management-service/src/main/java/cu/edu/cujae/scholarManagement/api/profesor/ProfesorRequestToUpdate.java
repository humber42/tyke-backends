package cu.edu.cujae.scholarManagement.api.profesor;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder@Getter
@Setter
public class ProfesorRequestToUpdate {
    private int id;
    private String facultad;
    private String gradoDocente;
    private String gradoCientifico;
    private String telefono;
}
