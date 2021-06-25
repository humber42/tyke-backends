package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.TipoPreguntaEntity;
import cu.edu.cujae.questionservice.dto.TipoPreguntaDto;
import cu.edu.cujae.questionservice.repository.TipoPreguntaRepository;
import cu.edu.cujae.questionservice.services.TipoPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class TipoPreguntaServiceImpl implements TipoPreguntaService {

    @Autowired
    TipoPreguntaRepository repository;
    @Autowired
    Mapper mapper;

    @Override
    public TipoPreguntaDto delete(long id) {
        Optional<TipoPreguntaDto> tipoPreguntaDto = getOneTipoPregunta(id);
        TipoPreguntaDto tipoPregunta = null;
        if (tipoPreguntaDto.isPresent()) {
            tipoPregunta = tipoPreguntaDto.get();
            repository.deleteById(id);
        }
        return tipoPregunta;
    }

    @Override
    public List<TipoPreguntaDto> getAllTipoPregunta() {
        return repository.findAll().stream().map(this::mappearTipoPregunta).collect(Collectors.toList());
    }

    @Override
    public Optional<TipoPreguntaDto> getOneTipoPregunta(long id) {
        return repository.findById(id).map(this::mappearTipoPregunta);
    }


    @Override
    public TipoPreguntaDto save(TipoPreguntaDto dto) {
        return mappearTipoPregunta(
                repository.save(
                        mapper.map(dto, TipoPreguntaEntity.class)
                )
        );
    }

    @Override
    public TipoPreguntaDto update(TipoPreguntaDto dto) {
        return mappearTipoPregunta(
                repository.saveAndFlush(
                        mapper.map(dto, TipoPreguntaEntity.class)
                )
        );
    }

    @Override
    public TipoPreguntaDto getByName(String tipo) {
        return repository.findByTipo(tipo).map(this::mappearTipoPregunta).get();
    }

    public TipoPreguntaDto mappearTipoPregunta(TipoPreguntaEntity entity) {
        return mapper.map(entity, TipoPreguntaDto.class);
    }
}
