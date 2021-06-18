package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.RespuestaEntity;
import cu.edu.cujae.questionservice.dto.RespuestaDto;
import cu.edu.cujae.questionservice.repository.RespuestaRespository;
import cu.edu.cujae.questionservice.services.RespuestaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RespuestaServiceImpl implements RespuestaService {

    @Autowired
    Mapper mapper;
    @Autowired
    RespuestaRespository repository;

    @Override
    public List<RespuestaDto> getAllRespuesta() {
        return repository.findAll().stream().map(this::mappearRespuesta).collect(Collectors.toList());
    }

    @Override
    public Optional<RespuestaDto> getOne(long id) {
        return repository.findById(id).map(this::mappearRespuesta);
    }

    @Override
    public RespuestaDto delete(long id) {
        Optional<RespuestaDto> dto = getOne(id);
        RespuestaDto respuestaDto = null;
        if (dto.isPresent()) {
            repository.deleteById(id);
            respuestaDto = dto.get();
        }
        return respuestaDto;
    }

    @Override
    public RespuestaDto save(RespuestaDto dto) {
        return mappearRespuesta(
                repository.save(
                        mapper.map(dto, RespuestaEntity.class)
                )
        );
    }

    @Override
    public RespuestaDto update(RespuestaDto dto) {
        return mappearRespuesta(
                repository.saveAndFlush(
                        mapper.map(dto, RespuestaEntity.class)
                )
        );
    }

    private RespuestaDto mappearRespuesta(RespuestaEntity entity) {
        return mapper.map(entity, RespuestaDto.class);
    }
}
