package cu.edu.cujae.scholarManagement.service.impl;


import cu.edu.cujae.scholarManagement.domain.CursoEntity;
import cu.edu.cujae.scholarManagement.dto.CursoDto;
import cu.edu.cujae.scholarManagement.repository.CursoRepository;
import cu.edu.cujae.scholarManagement.service.CursoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CursoServiceImpl implements CursoService {

    @Autowired
    CursoRepository repository;

    @Autowired
    Mapper mapper;

    @Override
    public CursoDto deleteCursoByCurso(String curso) {
        CursoDto dto = getCursoByName(curso);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public CursoDto deleteCursoById(int id) {
        CursoDto dto = getCursoById(id);
        repository.deleteById(id);
        return dto;
    }

    @Override
    public CursoDto getCursoActive() {
        return mapper.map(repository.getCursoEntityByActivoIsTrue(), CursoDto.class);
    }

    @Override
    public CursoDto getCursoById(int id) {
        return mapper.map(repository.getOne(id), CursoDto.class);
    }

    @Override
    public CursoDto getCursoByName(String curso) {
        return mapper.map(repository.getCursoEntityByCurso(curso),CursoDto.class);
    }

    @Override
    public CursoDto saveCurso(CursoDto curso) {
        List<CursoDto> cursos = findAllCursos();
        for(CursoDto cursoDto:cursos){
            cursoDto.setActivo(false);
            this.updateCurso(cursoDto);
        }
        CursoEntity entity = mapper.map(curso,CursoEntity.class);
        return mapper.map(repository.save(entity), CursoDto.class);
    }

    @Override
    public CursoDto updateCurso(CursoDto curso) {
        CursoEntity entity = mapper.map(curso,CursoEntity.class);
        return mapper.map(repository.saveAndFlush(entity), CursoDto.class);
    }

    @Override
    public List<CursoDto> findAllCursos() {
        return repository.findAll().stream().map(cursoEntity -> mapper.map(cursoEntity, CursoDto.class)).collect(Collectors.toList());
    }
}
