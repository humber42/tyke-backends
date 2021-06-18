package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.JugadorRegaloEntity;
import cu.edu.cujae.tykestrategy.dto.JugadorRegaloDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.JugadorRegaloRepository;
import cu.edu.cujae.tykestrategy.service.JugadorRegaloService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorRegaloServiceImpl implements JugadorRegaloService {

    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    JugadorRegaloRepository repository;
    @Autowired
    UserInterface userInterface;
    @Autowired
    Mapper mapper;

    @Override
    public int saveJugadorRegalo(JugadorRegaloDto dto) {
        return saveRepository.saveJugadorRegaloDto(dto);
    }

    @Override
    public List<JugadorRegaloDto> findAllJugadorRegalo() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JugadorRegaloDto> getJugadorRegaloById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<JugadorRegaloDto> updateJugadorRegalo(JugadorRegaloDto dto) {
        return Optional
                .of(repository.saveAndFlush(mapper.map(dto, JugadorRegaloEntity.class)))
                .map(this::mapperDto);
    }

    @Override
    public void deleteJugadorRegalo(JugadorRegaloDto dto) {
        repository.delete(mapper.map(dto, JugadorRegaloEntity.class));
    }

    @Override
    public void deleteJugadorRegaloById(long id) {
        repository.deleteById(id);
    }

    private JugadorRegaloDto mapperDto(JugadorRegaloEntity entity){
        JugadorRegaloDto dto = mapper.map(entity, JugadorRegaloDto.class);
        dto.setJugador(userInterface.searchById(entity.getIdJugador().intValue()));

        return dto;
    }
}
