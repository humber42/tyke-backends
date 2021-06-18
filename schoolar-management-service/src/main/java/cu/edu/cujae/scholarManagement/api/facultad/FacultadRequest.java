package cu.edu.cujae.scholarManagement.api.facultad;

import cu.edu.cujae.scholarManagement.api.carrera.CarreraRequest;
import cu.edu.cujae.scholarManagement.dto.CarreraDto;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FacultadRequest {
    private String facultad;
    private String siglas;
    private String imagen;

}
