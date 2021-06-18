package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.PreguntaEntity;
import cu.edu.cujae.questionservice.dto.AsignaturaDto;
import cu.edu.cujae.questionservice.dto.PreguntaDto;
import cu.edu.cujae.questionservice.feingInterface.AsignaturaInterface;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.PreguntaRepository;
import cu.edu.cujae.questionservice.services.PreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PreguntaServiceImpl implements PreguntaService {

    @Autowired
    PreguntaRepository repository;

    @Autowired
    AsignaturaInterface asignaturaInterface;

    @Autowired
    JdbcRepository jdbcRepository;

    @Autowired
    Mapper mapper;

    @Override
    public List<PreguntaDto> getAllPreguntas() {
        return repository.findAll().stream().map(this::mappearAsignatura).collect(Collectors.toList());
    }

    @Override
    public List<PreguntaDto> getAllPreguntasByTipo(String tipo) {
        return repository.getAllByTipoPreguntaByIdTipoPregunta_Tipo(tipo).stream().map(this::mappearAsignatura).collect(Collectors.toList());
    }

    @Override
    public Optional<PreguntaDto> findOnePregunta(long id) {
        Optional<PreguntaDto> pregunta = repository.findById(id).map(map->mapper.map(map, PreguntaDto.class));
        List<AsignaturaDto> lisdto = asignaturaInterface.getAllAsign();
        AsignaturaDto dto = asignaturaInterface.fetchByAsignaturaName(pregunta.get().getAsignatura());
        pregunta.get().setAsignaturaObject(dto);
        return pregunta;
    }

    @Override
    public PreguntaDto deletePregunta(long id) {
        PreguntaDto dto = this.findOnePregunta(id).get();
        repository.deleteById(id);
        return dto;
    }

    @Override
    public int savePregunta(PreguntaDto dto) {
        return jdbcRepository.savePregunta(dto);
    }

    @Override
    public PreguntaDto updatePregunta(PreguntaDto dto) {
        return mappearAsignatura(
                repository.saveAndFlush(mapper.map(dto, PreguntaEntity.class))
        );
    }


    private PreguntaDto mappearAsignatura(PreguntaEntity entity) {
        PreguntaDto dto = mapper.map(entity, PreguntaDto.class);
        AsignaturaDto asignatura = asignaturaInterface.fetchByAsignaturaName(entity.getAsignatura());
        dto.setAsignaturaObject(asignatura);
        return dto;
    }

}
