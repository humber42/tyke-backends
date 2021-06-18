package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.JugadorInsigniaEntity;
import cu.edu.cujae.tykestrategy.dto.JugadorInsigniaDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.JugadorInsigniaRepository;
import cu.edu.cujae.tykestrategy.service.JugadorInsigniaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorInsigniaServiceImpl implements JugadorInsigniaService {

    @Autowired
    UserInterface userInterface;
    @Autowired
    Mapper mapper;
    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    JugadorInsigniaRepository repository;

    @Override
    public int saveJugadorInsignia(JugadorInsigniaDto dto) {
        return saveRepository.saveJugadorInsigniaDto(dto);
    }

    @Override
    public List<JugadorInsigniaDto> findAllJugadorInsignia() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JugadorInsigniaDto> getJugadorInsigniaById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<JugadorInsigniaDto> updateJugadorInsignia(JugadorInsigniaDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto,JugadorInsigniaEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteJugadorInsignia(JugadorInsigniaDto dto) {
        repository.delete(mapper.map(dto, JugadorInsigniaEntity.class));
    }

    @Override
    public void deleteJugadorInsigniaById(long id) {
        repository.deleteById(id);
    }

    private JugadorInsigniaDto mapperDto(JugadorInsigniaEntity entity){
        JugadorInsigniaDto dto = mapper.map(entity, JugadorInsigniaDto.class);
        dto.setJugador(userInterface.searchById(entity.getIdJugador().intValue()));

        return dto;
    }
}
