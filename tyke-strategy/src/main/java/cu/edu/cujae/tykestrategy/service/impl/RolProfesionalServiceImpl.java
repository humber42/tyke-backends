package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.RolProfesionalEntity;
import cu.edu.cujae.tykestrategy.dto.RolProfesionalDto;
import cu.edu.cujae.tykestrategy.feignInterface.SchoolarInterface;
import cu.edu.cujae.tykestrategy.repository.RolProfesionalRepository;
import cu.edu.cujae.tykestrategy.service.RolProfesionalService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolProfesionalServiceImpl implements RolProfesionalService {

    @Autowired
    Mapper mapper;
    @Autowired
    RolProfesionalRepository repository;
    @Autowired
    SchoolarInterface schoolarInterface;


    @Override
    public Optional<RolProfesionalDto> saveRolProfesional(RolProfesionalDto dto) {
        return Optional
                .of(repository.save(mapper.map(dto, RolProfesionalEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public List<RolProfesionalDto> findAllRolProfesional() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<RolProfesionalDto> getRolProfesionalById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<RolProfesionalDto> updateRolProfesional(RolProfesionalDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, RolProfesionalEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteRolProfesional(RolProfesionalDto dto) {
        repository.delete(mapper.map(dto, RolProfesionalEntity.class));
    }

    @Override
    public void deleteRolProfesionalById(long id) {
        repository.deleteById(id);
    }

    private RolProfesionalDto mapperDto(RolProfesionalEntity entity){
        RolProfesionalDto dto =  mapper.map(entity,RolProfesionalDto.class);
        dto.setCarrera(schoolarInterface.searchCarreraById(entity.getIdCarrera().intValue()));
        dto.setTema(schoolarInterface.seatchTemaById(entity.getIdTema().intValue()));
        return dto;

    }
}

