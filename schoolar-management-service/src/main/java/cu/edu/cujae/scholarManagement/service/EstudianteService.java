package cu.edu.cujae.scholarManagement.service;

import cu.edu.cujae.scholarManagement.dto.EstudianteDto;

import java.util.List;

public interface EstudianteService {


    EstudianteDto getEstudianteById(int id);

    List<EstudianteDto> findAllEstudents();
    EstudianteDto saveEstudiante(EstudianteDto estudianteDto);
    EstudianteDto updateEstudiante(EstudianteDto estudianteDto);
    EstudianteDto deleteEstudianteById(int id);
    List<EstudianteDto> getAllStudentsByFacultad(int idFacultad);

}
