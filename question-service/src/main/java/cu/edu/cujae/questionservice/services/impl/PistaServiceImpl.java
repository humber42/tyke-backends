package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.PistaEntity;
import cu.edu.cujae.questionservice.dto.PistaDto;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.PistaRepository;
import cu.edu.cujae.questionservice.services.PistaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class PistaServiceImpl implements PistaService {

    @Autowired
    PistaRepository repository;
    @Autowired
    JdbcRepository jdbcRepository;
    @Autowired
    Mapper mapper;


    @Override
    public List<PistaDto> getAllPistas() {
        return repository.findAll().stream().map(pista -> mapper.map(pista, PistaDto.class)).collect(Collectors.toList());
    }

//    @Override
//    public List<PistaDto> getPistaByTipo(String tipo) {
//        return repository.getAllByTipoPistaByIdTipoPista_Tipo(tipo).stream().map(pista -> mapper.map(pista, PistaDto.class)).collect(Collectors.toList());
//    }

    @Override
    public Optional<PistaDto> findOnePista(long id) {
        return repository.findById(id).map(pistaEntity -> mapper.map(pistaEntity, PistaDto.class));
    }

    @Override
    public PistaDto deletePistaById(long id) {
        PistaDto pista = findOnePista(id).get();
        repository.deleteById(id);
        return pista;
    }

    @Override
    public int savePista(PistaDto dto) {
        return jdbcRepository.savePista(dto);
    }

    @Override
    public PistaDto updatePista(PistaDto dto) {
        return mapper.map(
                repository.saveAndFlush(
                        mapper.map(dto, PistaEntity.class)
                )
                , PistaDto.class
        );
    }
}
