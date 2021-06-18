package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.EstrategiaGrupoEntity;
import cu.edu.cujae.tykestrategy.dto.EstrategiaGrupoDto;
import cu.edu.cujae.tykestrategy.feignInterface.SchoolarInterface;
import cu.edu.cujae.tykestrategy.repository.EstrategiaGrupoRepository;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.service.EstrategiaGrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstrategiaGrupoServiceImpl implements EstrategiaGrupoService {

    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    Mapper mapper;
    @Autowired
    EstrategiaGrupoRepository repository;
    @Autowired
    SchoolarInterface schoolarInterface;

    @Override
    public List<EstrategiaGrupoDto> findAll() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public int newEstrategiaGrupo(EstrategiaGrupoDto dto) {
        return saveRepository.saveStrategyGrupo(dto);
    }

    @Override
    public Optional<EstrategiaGrupoDto> getEstrategiaGrupoById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<EstrategiaGrupoDto> updateEstrategiaGrupo(EstrategiaGrupoDto dto) {
        return Optional.of(
                repository.saveAndFlush(mapper.map(dto, EstrategiaGrupoEntity.class))
            )
                .map(this::mapperDto
                );
    }

    @Override
    public void deleteEstrategiaGrupo(EstrategiaGrupoDto dto) {
        repository.delete(mapper.map(dto, EstrategiaGrupoEntity.class));
    }

    @Override
    public void deleteEstrategiaGrupoById(long id) {
        repository.deleteById(id);
    }


    private EstrategiaGrupoDto mapperDto(EstrategiaGrupoEntity entity){
        EstrategiaGrupoDto estrategiaGrupoDto = mapper.map(entity, EstrategiaGrupoDto.class);
        estrategiaGrupoDto.setGrupo(schoolarInterface.searchGrupoById(entity.getIdGrupo().intValue()));
        return estrategiaGrupoDto;
    }
}
