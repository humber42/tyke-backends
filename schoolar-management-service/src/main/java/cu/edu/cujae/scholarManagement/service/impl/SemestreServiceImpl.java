package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.domain.SemestreEntity;
import cu.edu.cujae.scholarManagement.dto.SemestreDto;
import cu.edu.cujae.scholarManagement.repository.SemestreRepository;
import cu.edu.cujae.scholarManagement.service.SemestreService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemestreServiceImpl implements SemestreService {
    @Autowired
    Mapper mapper;
    @Autowired
    SemestreRepository repository;

    @Override
    public SemestreDto deleteById(int id) {
        SemestreDto dto = getSemestreById(id);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public List<SemestreDto> findAllSemestre() {
        return repository.findAll().stream().map(semestreEntity -> mapper.map(semestreEntity, SemestreDto.class)).collect(Collectors.toList());
    }

    @Override
    public SemestreDto deleteBySemestreName(String name) {
        SemestreDto dto = getSemestreByName(name);
        return dto;
    }

    @Override
    public SemestreDto getActiveSemestre() {
        return mapper.map(repository.getSemestreEntityByActivoIsTrue(), SemestreDto.class);
    }

    @Override
    public SemestreDto getSemestreById(int id) {
        return mapper.map(repository.getOne(id), SemestreDto.class);
    }

    @Override
    public SemestreDto getSemestreByName(String semestre) {
        return mapper.map(repository.getSemestreEntityBySemestre(semestre), SemestreDto.class);
    }

    @Override
    public SemestreDto saveSemestre(SemestreDto dto) {
        return mapper.map(repository.save(mapper.map(dto, SemestreEntity.class)), SemestreDto.class);
    }

    @Override
    public SemestreDto updateSemestreDto(SemestreDto dto) {
        return mapper.map(repository.saveAndFlush(mapper.map(dto, SemestreEntity.class)), SemestreDto.class);
    }
}
