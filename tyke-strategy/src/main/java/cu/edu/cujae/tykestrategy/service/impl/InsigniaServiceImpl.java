package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.InsigniaEntity;
import cu.edu.cujae.tykestrategy.dto.InsigniaDto;
import cu.edu.cujae.tykestrategy.repository.InsigniaRepository;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.service.InsigniaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InsigniaServiceImpl implements InsigniaService {

    @Autowired
    Mapper mapper;
    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    InsigniaRepository repository;

    @Override
    public int saveInsignia(InsigniaDto dto) {
        return saveRepository.saveInsignia(dto);
    }

    @Override
    public List<InsigniaDto> findAllInsignia() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<InsigniaDto> getInsigniaById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<InsigniaDto> updateInsignia(InsigniaDto dto) {
        return Optional.of(repository.saveAndFlush(mapper.map(dto, InsigniaEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteInsignia(InsigniaDto dto) {
        repository.delete(mapper.map(dto, InsigniaEntity.class));
    }

    @Override
    public void deleteInsigniaById(long id) {
        repository.deleteById(id);
    }

    private InsigniaDto mapperDto(InsigniaEntity entity){
        return mapper.map(entity, InsigniaDto.class);
    }
}
