package cu.edu.cujae.scholarManagement.api.carrera;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CarreraResponseWhithoutFaculty {
    private Integer id;
    private String nombre;
    private String siglas;
}
