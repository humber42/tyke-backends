package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.JugadorDesafioDto;

import java.util.List;
import java.util.Optional;

public interface JugadorDesafioService {
    Optional<JugadorDesafioDto> getJugadorDesafioById(long id);
    List<JugadorDesafioDto> findAllJugadorDesafio();
    int saveJugadorDesafio(JugadorDesafioDto dto);
    Optional<JugadorDesafioDto> updateJugadorDesafio(JugadorDesafioDto dto);
    void deleteJugadorDesafioById(long id);
    void deleteJugadorDesafio(JugadorDesafioDto dto);
}
