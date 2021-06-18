package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.JugadorEstrategiaEntity;
import cu.edu.cujae.tykestrategy.dto.JugadorEstrategiaDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.JugadorEstrategiaRepository;
import cu.edu.cujae.tykestrategy.service.JugadorEstrategiaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorEstrategiaServiceImpl implements JugadorEstrategiaService {

    @Autowired
    JugadorEstrategiaRepository repository;
    @Autowired
    Mapper mapper;
    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    UserInterface userInterface;


    @Override
    public int saveJugadorEstrategia(JugadorEstrategiaDto dto) {
        return saveRepository.saveJugadorEstratgiaDto(dto);
    }

    @Override
    public List<JugadorEstrategiaDto> findAllJugadorEstrategia() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JugadorEstrategiaDto> getJugadorEstrategiaById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<JugadorEstrategiaDto> updateJugadorEstrategia(JugadorEstrategiaDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, JugadorEstrategiaEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteJugadorEstrategia(JugadorEstrategiaDto dto) {
        repository.delete(mapper.map(dto, JugadorEstrategiaEntity.class));
    }

    @Override
    public void deleteJugadorEstrategiaById(long id) {
        repository.deleteById(id);
    }

    private JugadorEstrategiaDto mapperDto(JugadorEstrategiaEntity entity){
        JugadorEstrategiaDto dto = mapper.map(entity, JugadorEstrategiaDto.class);
        dto.setJugador(userInterface.searchById(entity.getIdJugador().intValue()));
        return dto;
    }



}
