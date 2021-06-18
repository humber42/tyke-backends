package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.TipoRegaloEntity;
import cu.edu.cujae.tykestrategy.dto.TipoRegaloDto;
import cu.edu.cujae.tykestrategy.repository.TipoRegaloRepository;
import cu.edu.cujae.tykestrategy.service.TipoRegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoRegaloServiceImpl implements TipoRegaloService {

    @Autowired
    Mapper mapper;
    @Autowired
    TipoRegaloRepository repository;

    @Override
    public Optional<TipoRegaloDto> saveTipoRegalo(TipoRegaloDto dto) {
        return Optional
                .of(repository.save(mapper.map(dto, TipoRegaloEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public List<TipoRegaloDto> findAllTipoRegalo() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<TipoRegaloDto> getTipoRegaloById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<TipoRegaloDto> updateTipoRegalo(TipoRegaloDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, TipoRegaloEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteTipoRegalo(TipoRegaloDto dto) {
        repository.delete(mapper.map(dto, TipoRegaloEntity.class));
    }

    @Override
    public void deleteTipoRegaloById(long id) {
        repository.deleteById(id);
    }

    private TipoRegaloDto mapperDto(TipoRegaloEntity entity){
        return mapper.map(entity,TipoRegaloDto.class);
    }
}
