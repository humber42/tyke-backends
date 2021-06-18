package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.OtorgamientoDto;

import java.util.List;
import java.util.Optional;

public interface OtorgamientoService {
    Optional<OtorgamientoDto> getOtorgamientoById(long id);
    List<OtorgamientoDto> findAllOtorgamiento();
    Optional<OtorgamientoDto> saveOtorgamiento(OtorgamientoDto dto);
    Optional<OtorgamientoDto> updateOtorgamiento(OtorgamientoDto dto);
    void deleteOtorgamientoById(long id);
    void deleteOtorgamiento(OtorgamientoDto dto);
}
