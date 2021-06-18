package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.EstrategiaEntity;
import cu.edu.cujae.tykestrategy.dto.EstrategiaDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.EstrategiaRepository;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.service.EstrategiaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstrategiaServiceImpl implements EstrategiaService {

    @Autowired
    Mapper mapper;
    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    EstrategiaRepository repository;
    @Autowired
    UserInterface userInterface;

    @Override
    public int saveEstrategia(EstrategiaDto dto) {
        return saveRepository.saveStrategy(dto);
    }

    @Override
    public List<EstrategiaDto> findAllEstrategia() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstrategiaDto> getEstrategiaById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<EstrategiaDto> updateEstrategiaDto(EstrategiaDto dto) {
        return Optional.of(
                repository.saveAndFlush(mapper.map(dto,EstrategiaEntity.class)
                )).map(this::mapperDto);
    }

    @Override
    public void deleteEstrategia(EstrategiaDto dto) {
        repository.delete(mapper.map(dto, EstrategiaEntity.class));
    }

    @Override
    public void deleteEstrategiaById(long id) {
        repository.deleteById(id);
    }

    private EstrategiaDto mapperDto(EstrategiaEntity entity){
        EstrategiaDto dto = mapper.map(entity, EstrategiaDto.class);
        dto.setProfesor(userInterface.searchById(entity.getIdProfesor().intValue()));
        return dto;

    }
}
