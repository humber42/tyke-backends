package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.OtorgamientoEntity;
import cu.edu.cujae.tykestrategy.dto.OtorgamientoDto;
import cu.edu.cujae.tykestrategy.repository.OtorgamientoRepository;
import cu.edu.cujae.tykestrategy.service.OtorgamientoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OtorgamientoServiceImpl implements OtorgamientoService {

    @Autowired
    Mapper mapper;
    @Autowired
    OtorgamientoRepository repository;

    @Override
    public Optional<OtorgamientoDto> saveOtorgamiento(OtorgamientoDto dto) {
        return Optional.of(repository.save(mapper.map(dto, OtorgamientoEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public List<OtorgamientoDto> findAllOtorgamiento() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<OtorgamientoDto> getOtorgamientoById(long id) {
        return repository.findById(id)
                .map(this::mapperDto);
    }

    @Override
    public Optional<OtorgamientoDto> updateOtorgamiento(OtorgamientoDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, OtorgamientoEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteOtorgamiento(OtorgamientoDto dto) {
        repository.delete(mapper.map(dto, OtorgamientoEntity.class));
    }

    @Override
    public void deleteOtorgamientoById(long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<OtorgamientoDto> getByName(String nombre) {
        return repository.findByOtorgamiento(nombre).map(this::mapperDto);
    }

    private OtorgamientoDto mapperDto(OtorgamientoEntity entity){
        return mapper.map(entity, OtorgamientoDto.class);
    }
}
