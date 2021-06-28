package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.TipoRegaloDto;

import java.util.List;
import java.util.Optional;

public interface TipoRegaloService {
    Optional<TipoRegaloDto> getTipoRegaloById(long id);
    List<TipoRegaloDto> findAllTipoRegalo();
    Optional<TipoRegaloDto> saveTipoRegalo(TipoRegaloDto dto);
    Optional<TipoRegaloDto> updateTipoRegalo(TipoRegaloDto dto);
    void deleteTipoRegaloById(long id);
    void deleteTipoRegalo(TipoRegaloDto dto);
    Optional<TipoRegaloDto> getByName(String nombre);
}
