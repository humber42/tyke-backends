package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.TemaEntity;
import cu.edu.cujae.scholarManagement.dto.AsignaturaTemaDto;
import cu.edu.cujae.scholarManagement.dto.TemaDto;
import cu.edu.cujae.scholarManagement.repository.TemaRepository;
import cu.edu.cujae.scholarManagement.service.TemaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TemaServiceImpl implements TemaService {

    @Autowired
    Mapper mapper;
    @Autowired
    TemaRepository repository;

    @Override
    public List<TemaDto> findAlltema() {
        return repository.findAll().stream().map(temaEntity -> mapper.map(temaEntity,TemaDto.class)).collect(Collectors.toList());
    }

    @Override
    public TemaDto deleteTemaById(int id) {
        TemaDto dto = getTemaById(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public TemaDto deleteTemaByNombre(String nombre) {
        TemaDto dto = getTemaByNombre(nombre);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public TemaDto getTemaById(int id) {
        return mapper.map(repository.getOne(id), TemaDto.class);
    }

    @Override
    public TemaDto getTemaByNombre(String nombre) {
        return mapper.map(repository.getTemaEntityByNombre(nombre), TemaDto.class);
    }

    @Override
    public TemaDto saveTema(TemaDto dto) {
        TemaEntity entity = new TemaEntity();
        entity.setNombre(dto.getNombre());
        entity.setDescription(dto.getDescription());
        return mapper.map(repository.save(entity), TemaDto.class);
    }

    @Override
    public List<TemaDto> getAllTemasByAsignatura(String asignatura) {
        return repository.findAll()
                .stream()
                .map(entity->mapper.map(entity, TemaDto.class))
                .filter(tema->{
                    boolean isFromSignature = false;
                    for(AsignaturaTemaDto asignaturaTemaDto: tema.getAsignaturaTemasById()){
                        if(asignaturaTemaDto.getAsignaturaByIdAsignatura().getNombre().equalsIgnoreCase(asignatura)){
                            isFromSignature=true;
                        }
                    }
                    return isFromSignature;
                })
                .collect(Collectors.toList());
    }

    @Override
    public TemaDto updateTema(TemaDto dto) {
        return mapper.map(repository.saveAndFlush(mapper.map(dto,TemaEntity.class)),TemaDto.class);
    }
}
