package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.RegaloEntity;
import cu.edu.cujae.tykestrategy.dto.RegaloDto;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.RegaloRepository;
import cu.edu.cujae.tykestrategy.service.RegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegaloServiceImpl implements RegaloService {

    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    RegaloRepository repository;
    @Autowired
    Mapper mapper;

    @Override
    public int saveRegalo(RegaloDto dto) {
        return saveRepository.saveRegalo(dto);
    }

    @Override
    public List<RegaloDto> findAllRegalo() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RegaloDto> getRegaloById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<RegaloDto> updateRegalo(RegaloDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, RegaloEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteRegalo(RegaloDto dto) {
        repository.delete(mapper.map(dto, RegaloEntity.class));
    }

    @Override
    public void deleteRegaloById(long id) {
        repository.deleteById(id);
    }

    private RegaloDto mapperDto(RegaloEntity entity){
        return mapper.map(entity, RegaloDto.class);
    }
}

