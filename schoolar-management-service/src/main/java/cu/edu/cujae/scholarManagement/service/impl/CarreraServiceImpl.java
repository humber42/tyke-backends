package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.CarreraEntity;
import cu.edu.cujae.scholarManagement.dto.CarreraDto;
import cu.edu.cujae.scholarManagement.repository.CarreraRepository;
import cu.edu.cujae.scholarManagement.service.CarreraService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CarreraServiceImpl implements CarreraService {

    @Autowired
    CarreraRepository repository;

    @Autowired
    Mapper mapper;

    @Override
    public CarreraDto deleteCarreraById(int id) {
        CarreraDto dto = getCarreraById(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public CarreraDto deleteCarreraByName(String name) {
        CarreraDto dto = getCarreraByName(name);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public CarreraDto getCarreraById(int id) {
        CarreraDto dto = mapper.map(repository.getOne(id),CarreraDto.class);
        return dto;
    }

    @Override
    public CarreraDto getCarreraByName(String name) {
        return mapper.map(repository.findCarreraEntityByNombre(name),CarreraDto.class);
    }

    @Override
    public CarreraDto getCarreraBySiglas(String siglas) {
        return mapper.map(repository.findCarreraEntityBySiglas(siglas),CarreraDto.class);
    }

    @Override
    public CarreraDto saveCarrera(CarreraDto carreraDto) {
        CarreraEntity entity = repository.save(mapper.map(carreraDto,CarreraEntity.class));
        return mapper.map(entity,CarreraDto.class);
    }

    @Override
    public CarreraDto updateCarrera(CarreraDto carreraDto) {
        CarreraEntity entity = repository.saveAndFlush(mapper.map(carreraDto,CarreraEntity.class));
        return mapper.map(entity,CarreraDto.class);
    }

    @Override
    public List<CarreraDto> findAllCarreraByFacultad(String facultad) {
        return repository.findCarreraEntitiesByFacultadByIdFacultad_Facultad(facultad)
                .stream().map(carreraEntity -> mapper.map(carreraEntity,CarreraDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<CarreraDto> findAllCarreras() {
        return repository.findAll().stream()
                .map(carreraEntity -> mapper.map(carreraEntity,CarreraDto.class)).collect(Collectors.toList());
    }
}
