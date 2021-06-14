package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.dto.AnnoSemestreDto;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import cu.edu.cujae.scholarManagement.service.AnnoSemestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnnoSemestreServiceImpl implements AnnoSemestreService {

    @Autowired
    JdbcRepository repository;

    @Override
    public int saveAnnoSemestre(AnnoSemestreDto dto) {
        return repository.saveAnnoSemestre(dto);
    }
}
