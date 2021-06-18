package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.EstrategiaTemaEntity;
import cu.edu.cujae.tykestrategy.dto.EstrategiaTemaDto;
import cu.edu.cujae.tykestrategy.feignInterface.SchoolarInterface;
import cu.edu.cujae.tykestrategy.repository.EstrategiaTemaRepository;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.service.EstrategiaTemaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstrategiaTemaServiceImpl implements EstrategiaTemaService {

    @Autowired
    JdbcSaveRepository saveRepository;

    @Autowired
    Mapper mapper;
    @Autowired
    EstrategiaTemaRepository repository;
    @Autowired
    SchoolarInterface schoolarInterface;

    @Override
    public Optional<EstrategiaTemaDto> updateEstrategiaDto(EstrategiaTemaDto dto) {
        return Optional.of(
                repository.saveAndFlush(mapper.map(dto, EstrategiaTemaEntity.class)
                )).map(this::mapperDto);
    }

    @Override
    public int saveEstrategiaTema(EstrategiaTemaDto dto) {
        return saveRepository.saveStrategyTema(dto);
    }

    @Override
    public List<EstrategiaTemaDto> findAllEstrategiaTema() {
        return repository.findAll().stream()
                .map(this::mapperDto).collect(Collectors.toList());
    }

    @Override
    public Optional<EstrategiaTemaDto> getEstrategiaTemaById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public void deleteEstrategiaTema(EstrategiaTemaDto dto) {
        repository.delete(mapper.map(dto, EstrategiaTemaEntity.class));
    }

    @Override
    public void deleteEstrategiaTemaById(long id) {
        repository.deleteById(id);
    }


    private EstrategiaTemaDto mapperDto(EstrategiaTemaEntity entity){
        EstrategiaTemaDto dto = mapper.map(entity, EstrategiaTemaDto.class);
        dto.setTema(schoolarInterface.seatchTemaById(entity.getIdTema().intValue()));
        return dto;
    }
}
