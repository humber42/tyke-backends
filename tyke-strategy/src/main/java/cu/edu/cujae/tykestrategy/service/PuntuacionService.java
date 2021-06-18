package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.PuntuacionDto;

import java.util.List;
import java.util.Optional;

public interface PuntuacionService {
    Optional<PuntuacionDto> getPuntuacionById(long id);
    List<PuntuacionDto> findAllPuntuacion();
    Optional<PuntuacionDto> savePuntuacion(PuntuacionDto dto);
    Optional<PuntuacionDto> updatePuntuacion(PuntuacionDto dto);
    void deletePuntuacionById(long id);
    void deletePuntuacion(PuntuacionDto dto);
}
