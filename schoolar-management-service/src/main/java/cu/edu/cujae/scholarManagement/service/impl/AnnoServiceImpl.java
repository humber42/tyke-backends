package cu.edu.cujae.scholarManagement.service.impl;

import cu.edu.cujae.scholarManagement.constants.ExceptionConstants;
import cu.edu.cujae.scholarManagement.domain.AnnoEntity;
import cu.edu.cujae.scholarManagement.dto.AnnoDto;
import cu.edu.cujae.scholarManagement.exceptions.EntityNotFoundException;
import cu.edu.cujae.scholarManagement.repository.AnnoRepository;
import cu.edu.cujae.scholarManagement.service.AnnoService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AnnoServiceImpl implements AnnoService {

    @Autowired
    AnnoRepository repository;
    @Autowired
    Mapper mapper;

    @Override
    public void deleteAnno(int id) {
        repository.deleteById(id);
    }

    @Override
    public AnnoDto deleteAnnoByName(String name) {
        AnnoEntity entity = repository.findAnnoEntityByAnno(name);
        if (Objects.isNull(entity))
            throw new EntityNotFoundException(ExceptionConstants.AnnoExceptionMessages.ANNO_NOT_FOUND_MESSAGE,ExceptionConstants.AnnoExceptionMessages.ANNO_NOT_FOUND_DEVELOPER_MESSAGE);
        AnnoDto dto = mapper.map(entity,AnnoDto.class);
        repository.deleteById(dto.getId());
        return dto;
    }

    @Override
    public AnnoDto findAnnoByName(String name) {
        return mapper.map(repository.findAnnoEntityByAnno(name),AnnoDto.class);
    }

    @Override
    public AnnoDto getAnnoById(int id) {
        return mapper.map(repository.getOne(id),AnnoDto.class);
    }

    @Override
    public AnnoDto saveAnno(AnnoDto annoDto) {
        AnnoEntity entity = mapper.map(annoDto,AnnoEntity.class);
        return mapper.map(repository.save(entity),AnnoDto.class);
    }

    @Override
    public List<AnnoDto> findAllAnno() {
        return repository.findAll().stream().map(annoEntity -> mapper.map(annoEntity,AnnoDto.class)).collect(Collectors.toList());
    }


    @Override
    public AnnoDto update(AnnoDto dto) {
        return mapper.map(
                repository.saveAndFlush(mapper.map(dto, AnnoEntity.class))
                        ,AnnoDto.class);
    }
}
