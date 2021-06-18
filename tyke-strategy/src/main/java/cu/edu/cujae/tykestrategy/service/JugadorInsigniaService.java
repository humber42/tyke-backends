package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.JugadorInsigniaDto;

import java.util.List;
import java.util.Optional;

public interface JugadorInsigniaService {
    Optional<JugadorInsigniaDto> getJugadorInsigniaById(long id);
    List<JugadorInsigniaDto> findAllJugadorInsignia();
    int saveJugadorInsignia(JugadorInsigniaDto dto);
    Optional<JugadorInsigniaDto> updateJugadorInsignia(JugadorInsigniaDto dto);
    void deleteJugadorInsigniaById(long id);
    void deleteJugadorInsignia(JugadorInsigniaDto dto);
}
