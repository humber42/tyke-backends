package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.SemestreAsignaturaDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.SemestreAsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SemestreAsignaturaServiceImpl implements SemestreAsignaturaService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveSemestreAsignatura(SemestreAsignaturaDto dto) {
        return repository.saveSemestreAsignatura(dto);
    }
}
