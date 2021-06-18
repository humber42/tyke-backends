package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.BonificacionPreguntaTiempoEntity;
import cu.edu.cujae.questionservice.dto.BonificacionPreguntaTiempoDto;
import cu.edu.cujae.questionservice.repository.BonificacionPreguntaTiempoRepository;
import cu.edu.cujae.questionservice.services.BonificacionPreguntaTiempoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BonificacionPreguntaTiempoServiceImpl implements BonificacionPreguntaTiempoService {

    @Autowired
    Mapper mapper;

    @Autowired
    BonificacionPreguntaTiempoRepository repository;


    @Override
    public Optional<BonificacionPreguntaTiempoDto> getOne(long id) {
        return repository.findById(id).map(this::mappear);
    }

    @Override
    public List<BonificacionPreguntaTiempoDto> getAll() {
        return repository.findAll().stream().map(this::mappear).collect(Collectors.toList());
    }

    @Override
    public Optional<BonificacionPreguntaTiempoDto> deleteById(long id) {
        Optional<BonificacionPreguntaTiempoDto> devolver = getOne(id);
        repository.deleteById(id);
        return devolver;
    }

    @Override
    public Optional<BonificacionPreguntaTiempoDto> saveBonificacion(BonificacionPreguntaTiempoDto dto) {
        return Optional.of(
                mappear(
                        repository.save(mapper.map(dto, BonificacionPreguntaTiempoEntity.class))
                )
        );
    }

    @Override
    public Optional<BonificacionPreguntaTiempoDto> updateBonificacion(BonificacionPreguntaTiempoDto dto) {
        return Optional.of(
                mappear(
                        repository.saveAndFlush(mapper.map(dto, BonificacionPreguntaTiempoEntity.class))
                )
        );
    }


    private BonificacionPreguntaTiempoDto mappear(BonificacionPreguntaTiempoEntity entity) {
        return mapper.map(entity, BonificacionPreguntaTiempoDto.class);
    }
}
