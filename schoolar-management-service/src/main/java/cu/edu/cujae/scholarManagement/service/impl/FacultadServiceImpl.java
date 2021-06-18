package cu.edu.cujae.scholarManagement.service.impl;


import cu.edu.cujae.scholarManagement.domain.FacultadEntity;
import cu.edu.cujae.scholarManagement.dto.FacultadDto;
import cu.edu.cujae.scholarManagement.repository.FacultadRepository;
import cu.edu.cujae.scholarManagement.service.FacultadService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultadServiceImpl implements FacultadService {

    @Autowired
    FacultadRepository repository;

    @Autowired
    Mapper mapper;

    @Override
    public FacultadDto deleteFacultadById(int id) {
        FacultadDto facultadDto = getFacultadById(id);
        repository.deleteById(id);
        return facultadDto;
    }

    @Override
    public FacultadDto deleteFacultadByName(String name) {
        FacultadDto facultadDto = getFacultadByFacultad(name);
        repository.deleteById(facultadDto.getId());
        return facultadDto;
    }

    @Override
    public FacultadDto getFacultadByFacultad(String facultad) {
        return mapper.map(repository.getFacultadEntityByFacultad(facultad),FacultadDto.class);
    }

    @Override
    public FacultadDto getFacultadById(int id) {
        return mapper.map(repository.getOne(id),FacultadDto.class);
    }

    @Override
    public FacultadDto getFacultadBySiglas(String siglas) {
        return mapper.map(repository.getFacultadEntityBySiglas(siglas),FacultadDto.class);
    }

    @Override
    public FacultadDto saveFacultad(FacultadDto dto) {
        FacultadEntity entity = mapper.map(dto,
                FacultadEntity.class);
        return mapper.map(repository.save(entity),FacultadDto.class);
    }

    @Override
    public FacultadDto updateFacultad(FacultadDto dto) {
        FacultadEntity entity = mapper.map(dto,FacultadEntity.class);
        return mapper.map(repository.saveAndFlush(entity),FacultadDto.class);
    }

    @Override
    public List<FacultadDto> findAllFaculties() {
        return repository.findAll().stream().map(facultadEntity -> mapper.map(facultadEntity,FacultadDto.class)).collect(Collectors.toList());
    }
}
