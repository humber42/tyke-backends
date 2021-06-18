package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.PistaPreguntaEntity;
import cu.edu.cujae.questionservice.dto.PistaPreguntaDto;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.PistaPreguntaRepository;
import cu.edu.cujae.questionservice.services.PistaPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PistaPreguntaServiceImpl implements PistaPreguntaService {

    @Autowired
    JdbcRepository repository;
    @Autowired
    Mapper mapper;

    @Override
    public int save(PistaPreguntaDto dto) {
        return repository.savePistaPregunta(dto);
    }

    private PistaPreguntaDto mappear(PistaPreguntaEntity entity){
        return mapper.map(entity, PistaPreguntaDto.class);
    }
}
