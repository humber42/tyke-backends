package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.PuntuacionEntity;
import cu.edu.cujae.tykestrategy.dto.PuntuacionDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.PuntuacionRepository;
import cu.edu.cujae.tykestrategy.service.PuntuacionService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PuntuacionServiceImpl implements PuntuacionService {

    @Autowired
    Mapper mapper;
    @Autowired
    UserInterface userInterface;
    @Autowired
    PuntuacionRepository repository;

    @Override
    public Optional<PuntuacionDto> savePuntuacion(PuntuacionDto dto) {
        return Optional
                .of(
                        repository.save(mapper.map(dto, PuntuacionEntity.class))
                )
                .map(this::mapperDto);
    }

    @Override
    public List<PuntuacionDto> findAllPuntuacion() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<PuntuacionDto> getPuntuacionById(long id) {
        return repository.findById(id)
                .map(this::mapperDto);
    }

    @Override
    public Optional<PuntuacionDto> updatePuntuacion(PuntuacionDto dto) {
        return Optional
                .of(
                        repository.saveAndFlush(mapper.map(dto, PuntuacionEntity.class))
                )
                .map(this::mapperDto);
    }

    @Override
    public void deletePuntuacion(PuntuacionDto dto) {
        repository.delete(mapper.map(dto, PuntuacionEntity.class));
    }

    @Override
    public void deletePuntuacionById(long id) {
        repository.deleteById(id);
    }

    private PuntuacionDto mapperDto(PuntuacionEntity entity){
        PuntuacionDto dto = mapper.map(entity, PuntuacionDto.class);
        dto.setUsuario(userInterface.searchById(entity.getIdEstudiante().intValue()));
        return dto;
    }

}

