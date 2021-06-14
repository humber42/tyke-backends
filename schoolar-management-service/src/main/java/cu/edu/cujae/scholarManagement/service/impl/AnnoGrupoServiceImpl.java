package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.AnnoGrupoDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.AnnoGrupoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnoGrupoServiceImpl implements AnnoGrupoService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveAnnoGrupo(AnnoGrupoDto dto) {
        return repository.saveAnnoGrupo(dto);
    }
}
