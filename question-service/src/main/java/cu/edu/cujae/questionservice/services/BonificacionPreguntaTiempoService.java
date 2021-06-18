package cu.edu.cujae.questionservice.services;

import cu.edu.cujae.questionservice.dto.BonificacionPreguntaTiempoDto;

import java.util.List;
import java.util.Optional;

public interface BonificacionPreguntaTiempoService {

    List<BonificacionPreguntaTiempoDto> getAll();

    Optional<BonificacionPreguntaTiempoDto> getOne(long id);

    Optional<BonificacionPreguntaTiempoDto> deleteById(long id);

    Optional<BonificacionPreguntaTiempoDto> saveBonificacion(BonificacionPreguntaTiempoDto dto);

    Optional<BonificacionPreguntaTiempoDto> updateBonificacion(BonificacionPreguntaTiempoDto dto);

}
