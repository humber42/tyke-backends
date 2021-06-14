package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.GrupoEntity;
import cu.edu.cujae.scholarManagement.dto.GrupoDto;
import cu.edu.cujae.scholarManagement.repository.GrupoRepository;
import cu.edu.cujae.scholarManagement.service.GrupoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GrupoServiceImpl implements GrupoService {

    @Autowired
    GrupoRepository repository;
    @Autowired
    Mapper mapper;

    @Override
    public GrupoDto deleteGrupoById(int id) {
        GrupoDto dto = getGrupoById(id);
        repository.deleteById(dto.getId().intValue());
        return dto;
    }
    @Override
    public GrupoDto deleteGrupoByName(String name) {
        GrupoDto dto = getGrupoByName(name);
        repository.deleteById(dto.getId().intValue());
        return dto;
    }

    @Override
    public GrupoDto getGrupoById(int id) {
        return mapper.map(repository.getOne(id), GrupoDto.class);
    }

    @Override
    public GrupoDto getGrupoByName(String name) {
        return mapper.map(repository.getGrupoEntityByGrupo(name), GrupoDto.class);
    }

    @Override
    public GrupoDto saveGrupo(GrupoDto dto) {
        return mapper.map(repository.save(mapper.map(dto, GrupoEntity.class)), GrupoDto.class);
    }

    @Override
    public GrupoDto updateGrupo(GrupoDto dto) {
        return mapper.map(repository.saveAndFlush(mapper.map(dto,GrupoEntity.class)), GrupoDto.class);
    }

    @Override
    public List<GrupoDto> findAllGrupo() {
        return repository.findAll().stream().map(grupoEntity -> mapper.map(grupoEntity, GrupoDto.class)).collect(Collectors.toList());
    }
}
