package cu.edu.cujae.scholarManagement.api.curso;


import lombok.*;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class CursoRequest {
    private String curso;
    private Boolean activo;
}
