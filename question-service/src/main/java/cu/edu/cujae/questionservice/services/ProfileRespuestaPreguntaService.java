package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.ProfileRespuestaPreguntaDto;

import java.util.List;
import java.util.Optional;

public interface ProfileRespuestaPreguntaService {
    List<ProfileRespuestaPreguntaDto> getAllProfileRespuestaPregunta();
    Optional<ProfileRespuestaPreguntaDto> getOneProfileRespuestaPregunta(long id);
    int save(ProfileRespuestaPreguntaDto dto);
    ProfileRespuestaPreguntaDto update(ProfileRespuestaPreguntaDto dto);

    ProfileRespuestaPreguntaDto delete(long id);

}
