package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.TipoPistaEntity;
import cu.edu.cujae.questionservice.dto.TipoPistaDto;
import cu.edu.cujae.questionservice.repository.TipoPistaRepository;
import cu.edu.cujae.questionservice.services.TipoPistaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoPistaServiceImpl implements TipoPistaService {

    @Autowired
    Mapper mapper;
    @Autowired
    TipoPistaRepository repository;

    @Override
    public TipoPistaDto delete(long id) {
        Optional<TipoPistaDto> optionalTipoPistaDto = getOneTipoPista(id);
        TipoPistaDto dto = null;
        if (optionalTipoPistaDto.isPresent()) {
            dto = optionalTipoPistaDto.get();
            repository.deleteById(id);
        }
        return dto;
    }

    @Override
    public List<TipoPistaDto> getAllTipoPista() {
        return repository.findAll().stream().map(this::mappearTipoPista).collect(Collectors.toList());
    }

    @Override
    public Optional<TipoPistaDto> getOneTipoPista(long id) {
        return repository.findById(id).map(this::mappearTipoPista);
    }

    @Override
    public TipoPistaDto save(TipoPistaDto dto) {
        return mappearTipoPista(
                repository.save(
                        mapper.map(dto, TipoPistaEntity.class))
        )
                ;
    }

    @Override
    public TipoPistaDto update(TipoPistaDto dto) {
        return mappearTipoPista(
                repository.saveAndFlush(
                        mapper.map(dto, TipoPistaEntity.class))
        )
                ;
    }

    @Override
    public TipoPistaDto getByName(String name) {
        return repository.findByTipo(name).map(this::mappearTipoPista).get();
    }

    private TipoPistaDto mappearTipoPista(TipoPistaEntity entity) {
        return mapper.map(entity, TipoPistaDto.class);
    }

}
