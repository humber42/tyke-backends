package cu.edu.cujae.tykestrategy.dto;

import lombok.*;

@Builder
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class ProfesorDto {
    private long id;
    private String gradoCientifico;
    private String gradoDocente;
    private UserDto usuario;
}
