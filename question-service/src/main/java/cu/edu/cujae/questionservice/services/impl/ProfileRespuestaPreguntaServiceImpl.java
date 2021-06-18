package cu.edu.cujae.questionservice.services.impl;

import cu.edu.cujae.questionservice.domain.ProfileRespuestaPreguntaEntity;
import cu.edu.cujae.questionservice.dto.ProfileRespuestaPreguntaDto;
import cu.edu.cujae.questionservice.dto.UserDto;
import cu.edu.cujae.questionservice.feingInterface.UserInterface;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import cu.edu.cujae.questionservice.repository.ProfileRespuestaPreguntaRepository;
import cu.edu.cujae.questionservice.services.ProfileRespuestaPreguntaService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProfileRespuestaPreguntaServiceImpl implements ProfileRespuestaPreguntaService {

    @Autowired
    Mapper mapper;
    @Autowired
    ProfileRespuestaPreguntaRepository repository;
    @Autowired
    UserInterface userInterface;
    @Autowired
    JdbcRepository jdbcRepository;

    @Override
    public List<ProfileRespuestaPreguntaDto> getAllProfileRespuestaPregunta() {
        return repository.findAll().stream().map(this::mappearProfile).collect(Collectors.toList());
    }

    @Override
    public Optional<ProfileRespuestaPreguntaDto> getOneProfileRespuestaPregunta(long id) {
        return repository.findById(id).map(this::mappearProfile);
    }

    @Override
    public ProfileRespuestaPreguntaDto delete(long id) {
        ProfileRespuestaPreguntaDto dto = null;
        if (getOneProfileRespuestaPregunta(id).isPresent()) {
            dto = getOneProfileRespuestaPregunta(id).get();
            repository.deleteById(id);
        }
        return dto;
    }

    @Override
    public int save(ProfileRespuestaPreguntaDto dto) {
        return jdbcRepository.saveProfileRespuesta(dto);
    }

    @Override
    public ProfileRespuestaPreguntaDto update(ProfileRespuestaPreguntaDto dto) {
        return this.mappearProfile(
                repository.saveAndFlush(
                        mapper.map(dto, ProfileRespuestaPreguntaEntity.class)
                )
        );
    }

    private ProfileRespuestaPreguntaDto mappearProfile(ProfileRespuestaPreguntaEntity entity) {
        ProfileRespuestaPreguntaDto dto = mapper.map(entity, ProfileRespuestaPreguntaDto.class);
        UserDto userDto = userInterface.searchById(entity.getUsername());
        dto.setUserDto(userDto);
        return dto;
    }
}
