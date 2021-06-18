package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.JugadorRegaloDto;

import java.util.List;
import java.util.Optional;

public interface JugadorRegaloService {
    Optional<JugadorRegaloDto> getJugadorRegaloById(long id);
    List<JugadorRegaloDto> findAllJugadorRegalo();
    int saveJugadorRegalo(JugadorRegaloDto dto);
    Optional<JugadorRegaloDto> updateJugadorRegalo(JugadorRegaloDto dto);
    void deleteJugadorRegaloById(long id);
    void deleteJugadorRegalo(JugadorRegaloDto dto);
}
