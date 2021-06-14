package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.AsignaturaTemaDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.AsignaturaTemaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsignaturaTemaServiceImpl implements AsignaturaTemaService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveAsignaturaTema(AsignaturaTemaDto dto) {
        return repository.saveAsignaturaTema(dto);
    }
}
