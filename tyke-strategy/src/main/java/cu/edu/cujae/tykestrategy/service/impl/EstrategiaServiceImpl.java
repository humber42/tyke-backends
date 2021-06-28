package cu.edu.cujae.tykestrategy.service.impl;

import cu.edu.cujae.tykestrategy.api.models.estrategia.EstrategiaRequestWithAllThings;
import cu.edu.cujae.tykestrategy.domain.EstrategiaEntity;
import cu.edu.cujae.tykestrategy.domain.EstrategiaPreguntaEntity;
import cu.edu.cujae.tykestrategy.domain.EstrategiaTemaEntity;
import cu.edu.cujae.tykestrategy.dto.*;
import cu.edu.cujae.tykestrategy.feignInterface.SchoolarInterface;
import cu.edu.cujae.tykestrategy.feignInterface.UserInterface;
import cu.edu.cujae.tykestrategy.repository.*;
import cu.edu.cujae.tykestrategy.service.*;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstrategiaServiceImpl implements EstrategiaService {

    @Autowired
    Mapper mapper;
    @Autowired
    JdbcSaveRepository saveRepository;
    @Autowired
    EstrategiaRepository repository;
    @Autowired
    UserInterface userInterface;
    @Autowired
    EstrategiaPreguntaRepository estrategiaPreguntaRepository;
    @Autowired
    EstrategiaGrupoRepository estrategiaGrupoService;
    @Autowired
    EstrategiaTemaRepository estrategiaTemaService;
    @Autowired
    EstrategiaPreguntaRepository repositoryEstrategiaPregunta;
    @Autowired
    JugadorDesafioRepository jugadorDesafioService;
    @Autowired
    JugadorEstrategiaRepository jugadorEstrategiaService;
    @Autowired
    SchoolarInterface schoolarInterface;

    @Override
    public int saveEstrategia(EstrategiaDto dto) {
        return saveRepository.saveStrategy(dto);
    }

    @Override
    public List<EstrategiaDto> findAllEstrategia() {
        return repository.findAll().stream()
                .map(this::mapperDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EstrategiaDto> getEstrategiaById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<EstrategiaDto> updateEstrategiaDto(EstrategiaDto dto) {
        return Optional.of(
                repository.saveAndFlush(mapper.map(dto,EstrategiaEntity.class)
                )).map(this::mapperDto);
    }

    @Override
    public void deleteEstrategia(EstrategiaDto dto) {
        repository.delete(mapper.map(dto, EstrategiaEntity.class));
    }

    @Override
    public void deleteEstrategiaById(long id) {
        repository.deleteById(id);
    }

    private EstrategiaDto mapperDto(EstrategiaEntity entity){
        EstrategiaDto dto = EstrategiaDto.builder()
                .nombre(entity.getNombre())
                .idProfesor(entity.getIdProfesor())
                .fecha(entity.getFecha())
                .idEstrategia(entity.getIdEstrategia())
                .puntos(entity.getPuntos())
                .habilitada(entity.getHabilitada())
                .evaluada(entity.getEvaluada())
                .build();
        dto.setProfesor(schoolarInterface.searchProfesorById(entity.getIdProfesor().intValue()));

        //Setting grupos
        dto.setGrupos(estrategiaGrupoService
                .findAllByEstrategia_IdEstrategia(entity.getIdEstrategia())
                .stream()
                .map(grupos->mapper.map(grupos,EstrategiaGrupoDto.class))
                .map(grupos->{
                    GrupoDto grupoDto =schoolarInterface.searchGrupoById(grupos.getIdGrupo().intValue());
                    grupos.setGrupo(grupoDto);
                    return grupos;
                })
                .collect(Collectors.toList())
        );

        //Setting temas
        dto.setTemas(estrategiaTemaService
                .findAllByEstrategia_IdEstrategia(entity.getIdEstrategia())
                .stream()
                .map(temas->mapper.map(temas,EstrategiaTemaDto.class))
                .map(temas->{
                    TemaDto tema = schoolarInterface.seatchTemaById(temas.getIdTema().intValue());
                    temas.setTema(tema);
                    return temas;
                })
                .collect(Collectors.toList()));


        dto.setDesafios(jugadorDesafioService
                        .findAllByEstrategia_IdEstrategia(entity.getIdEstrategia())
                        .stream()
                .map(desafios->mapper.map(desafios,JugadorDesafioDto.class))
                .collect(Collectors.toList())
        );
        dto.setJugadores(jugadorEstrategiaService
                .findAllByEstrategia_IdEstrategia(entity.getIdEstrategia())
                .stream()
                .map(jugadores->mapper.map(jugadores,JugadorEstrategiaDto.class))
                .collect(Collectors.toList())
        );
        dto.setEstrategiaPreguntasByIdEstrategia(repositoryEstrategiaPregunta
                .findAllByIdEstrategia(entity.getIdEstrategia())
                .stream()
                .map(pregunta->mapper.map(pregunta,EstrategiaPreguntaDto.class))
                .collect(Collectors.toList())
        );
        return dto;

    }

    @Override
    public int saveEstrategiaComplete(EstrategiaRequestWithAllThings estrategiaRequest) {
        EstrategiaDto dto = EstrategiaDto.builder()
                .nombre(estrategiaRequest.getNombre())
                .puntos(estrategiaRequest.getCantPuntos())
                .habilitada(estrategiaRequest.isHabilitada())
                .evaluada(estrategiaRequest.isEvaluada())
                .fecha(Date.valueOf(LocalDate.now()))
                .idProfesor(estrategiaRequest.getIdProfesor())
                .build();
        saveRepository.saveStrategy(dto);
        long idStrategia = repository.
                findByNombreAndIdProfesor(
                        estrategiaRequest.getNombre(),
                        estrategiaRequest.getIdProfesor()).get().getIdEstrategia();

        //Salvando los temas de la estrategia
        for (TemaDto tema:estrategiaRequest.getTemas()
             ) {
            saveRepository.saveStrategyTema(EstrategiaTemaDto.builder()
            .idEstrategia(idStrategia).idTema(tema.getId()).build());
        }

        //Salvando los grupos para la estrategia
        for(GrupoDto grupoDto:estrategiaRequest.getGrupos()){
            saveRepository.saveStrategyGrupo(EstrategiaGrupoDto.builder()
                    .idEstrategia(idStrategia)
                    .idGrupo(grupoDto.getId())
                    .build());
        }

        //Salvando las preguntas
        for(PreguntaDto preguntaDto:estrategiaRequest.getPregunta()){
            EstrategiaPreguntaEntity entity = mapper.map(EstrategiaPreguntaDto.builder().idEstrategia(idStrategia)
                    .idPregunta(preguntaDto.getId()).build()
                    , EstrategiaPreguntaEntity.class);
            estrategiaPreguntaRepository.save(entity);
        }


        return 0;
    }
}
