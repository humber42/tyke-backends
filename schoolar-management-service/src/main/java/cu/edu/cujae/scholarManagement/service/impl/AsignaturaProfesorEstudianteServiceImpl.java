package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.AsignaturaProfesorEstudianteDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.AsignaturaProfesorEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaProfesorEstudianteServiceImpl implements AsignaturaProfesorEstudianteService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveAsignaturaProfesorEstudiante(AsignaturaProfesorEstudianteDto dto) {
        return repository.saveAsignaturaProfesorEstudiante(dto);
    }
}
