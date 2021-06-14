package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.AsignaturaEntity;
import cu.edu.cujae.scholarManagement.dto.AsignaturaDto;
import cu.edu.cujae.scholarManagement.repository.AsignaturaRepository;
import cu.edu.cujae.scholarManagement.service.AsignaturaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AsignaturaServiceImpl implements AsignaturaService {

    @Autowired
    AsignaturaRepository repository;

    @Autowired
    Mapper mapper;

    @Override
    public AsignaturaDto saveAsignatura(AsignaturaDto dto) {
        AsignaturaEntity entity = mapper.map(dto,AsignaturaEntity.class);
        return mapper.map(repository.save(entity),AsignaturaDto.class);
    }

    @Override
    public long countAsignaturas() {
        return repository.count();
    }

    @Override
    @Transactional
    public List<AsignaturaDto> getAllAsignaturas() {
        return repository.findAll().stream().map(entity -> mapper.map(entity,AsignaturaDto.class)).collect(Collectors.toList());
    }

    @Override
    public AsignaturaDto findByNameAsignatura(String name) {
        AsignaturaDto dto = mapper.map(repository.findByNombre(name),AsignaturaDto.class);
        return dto;
    }

    @Override
    public AsignaturaDto findOne(int id) {
        return mapper.map(repository.getOne(id),AsignaturaDto.class);
    }

    @Override
    public AsignaturaDto updateAsignatura(AsignaturaDto dto) {
        return mapper.map(repository.save(mapper.map(dto,AsignaturaEntity.class)),AsignaturaDto.class);
    }

    @Override
    public AsignaturaDto deleteByAsignaturaName(String asignatura) {
        AsignaturaDto asignaturaDto = findByNameAsignatura(asignatura);
        repository.deleteById(asignaturaDto.getId());
        return asignaturaDto;
    }

    @Override
    public List<AsignaturaDto> activeAsignatura() {
        return repository.findAllByActivoIsTrue().stream().map(entity -> mapper.map(entity,AsignaturaDto.class)).collect(Collectors.toList());
    }


}
