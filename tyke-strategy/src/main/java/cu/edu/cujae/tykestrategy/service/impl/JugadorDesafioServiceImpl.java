package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.domain.JugadorDesafioEntity;
import cu.edu.cujae.tykestrategy.dto.JugadorDesafioDto;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import cu.edu.cujae.tykestrategy.repository.JugadorDesafioRepository;
import cu.edu.cujae.tykestrategy.service.JugadorDesafioService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JugadorDesafioServiceImpl implements JugadorDesafioService {

    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    Mapper mapper;
    @Autowired
    JugadorDesafioRepository repository;
    @Autowired
    UserInterface userInterface;

    @Override
    public int saveJugadorDesafio(JugadorDesafioDto dto) {
        return saveRepository.saveJugadorDesafio(dto);
    }

    @Override
    public List<JugadorDesafioDto> findAllJugadorDesafio() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<JugadorDesafioDto> getJugadorDesafioById(long id) {
        return repository.findById(id).map(this::mapperDto);
    }

    @Override
    public Optional<JugadorDesafioDto> updateJugadorDesafio(JugadorDesafioDto dto) {
        return Optional
                .of(
                        repository.saveAndFlush(mapper.map(dto, JugadorDesafioEntity.class))
                )
                .map(this::mapperDto);
    }

    @Override
    public void deleteJugadorDesafio(JugadorDesafioDto dto) {
        repository.delete(mapper.map(dto,JugadorDesafioEntity.class));
    }

    @Override
    public void deleteJugadorDesafioById(long id) {
        repository.deleteById(id);
    }

    private JugadorDesafioDto mapperDto(JugadorDesafioEntity entity){
        JugadorDesafioDto dto = mapper.map(entity, JugadorDesafioDto.class);
        dto.setJugadorDesafiado(userInterface.searchById(entity.getIdJugadorDesafiado().intValue()));
        dto.setJugadorDesafiante(userInterface.searchById(entity.getIdJugadorDesafiante().intValue()));
        return dto;
    }
}
