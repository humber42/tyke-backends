package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.EstudianteGrupoDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.EstudianteGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteGrupoServiceImpl implements EstudianteGrupoService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveEstudianteGrupo(EstudianteGrupoDto dto) {
        return repository.saveEstudianteGrupo(dto);
    }
}
