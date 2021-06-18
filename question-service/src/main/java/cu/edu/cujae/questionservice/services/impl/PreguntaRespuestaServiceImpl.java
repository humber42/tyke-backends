package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.PreguntaRespuestaEntity;
import cu.edu.cujae.questionservice.dto.PreguntaRespuestaDto;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.PreguntaRespuestaRepository;
import cu.edu.cujae.questionservice.services.PreguntaRespuestaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PreguntaRespuestaServiceImpl implements PreguntaRespuestaService {

    @Autowired
    Mapper mapper;
    @Autowired
    JdbcRepository repository;

    @Override
    public int savePreguntaRespuesta(PreguntaRespuestaDto dto) {
        return repository.savePreguntaRespuesta(dto);
    }

    private PreguntaRespuestaDto mappear(PreguntaRespuestaEntity entity){
        return mapper.map(entity, PreguntaRespuestaDto.class);
    }


}
