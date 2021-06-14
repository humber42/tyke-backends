package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.CursoAnnoDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.CursoAnnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoAnnoServiceImpl implements CursoAnnoService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveCursoAnno(CursoAnnoDto dto) {
        return repository.saveCursoAnno(dto);
    }
}
