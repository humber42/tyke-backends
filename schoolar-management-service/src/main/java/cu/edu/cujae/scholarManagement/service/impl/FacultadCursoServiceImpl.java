package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.FacultadCursoDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.FacultadCursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.quartz.QuartzProperties;
import org.springframework.stereotype.Service;

@Service
public class FacultadCursoServiceImpl implements FacultadCursoService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveFacultadCurso(FacultadCursoDto dto) {
        return repository.saveFacultadCurso(dto);
    }
}
