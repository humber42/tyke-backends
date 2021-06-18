package cu.edu.cujae.scholarManagement.service;


import cu.edu.cujae.scholarManagement.api.profesor.ProfesorRequest;
import cu.edu.cujae.scholarManagement.api.profesor.ProfesorRequestToUpdate;
import cu.edu.cujae.scholarManagement.dto.ProfesorDto;

import java.util.List;

public interface ProfesorService {

    ProfesorDto getProfesorById(int id);
    List<ProfesorDto> findAllProfesors();
    ProfesorDto saveProfesor(ProfesorRequest dto);
    ProfesorDto updateProfesor(ProfesorRequestToUpdate dto);
    ProfesorDto deleteById(int id);

}
