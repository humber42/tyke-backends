package cu.edu.cujae.scholarManagement.api.facultad;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FacultadResponseWithoutCarreer {
    private int id;
    private String facultad;
    private String siglas;
}
