package cu.edu.cujae.scholarManagement.service;


import cu.edu.cujae.scholarManagement.dto.ProfesorDto;

import java.util.List;

public interface ProfesorService {

    ProfesorDto getProfesorById(int id);
    List<ProfesorDto> findAllProfesors();
    ProfesorDto saveProfesor(ProfesorDto dto);
    ProfesorDto updateProfesor(ProfesorDto dto);
    ProfesorDto deleteById(int id);

}
