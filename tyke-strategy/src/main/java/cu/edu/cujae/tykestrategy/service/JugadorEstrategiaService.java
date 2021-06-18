package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.JugadorEstrategiaDto;

import java.util.List;
import java.util.Optional;

public interface JugadorEstrategiaService {
    Optional<JugadorEstrategiaDto> getJugadorEstrategiaById(long id);
    List<JugadorEstrategiaDto> findAllJugadorEstrategia();
    int saveJugadorEstrategia(JugadorEstrategiaDto dto);
    Optional<JugadorEstrategiaDto> updateJugadorEstrategia(JugadorEstrategiaDto dto);
    void deleteJugadorEstrategiaById(long id);
    void deleteJugadorEstrategia(JugadorEstrategiaDto dto);
}
