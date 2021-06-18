package cu.edu.cujae.tykestrategy.service;

import cu.edu.cujae.tykestrategy.dto.InsigniaDto;

import java.util.List;
import java.util.Optional;

public interface InsigniaService {
    Optional<InsigniaDto> getInsigniaById(long id);
    List<InsigniaDto> findAllInsignia();
    int saveInsignia(InsigniaDto dto);
    Optional<InsigniaDto> updateInsignia(InsigniaDto dto);
    void deleteInsigniaById(long id);
    void deleteInsignia(InsigniaDto dto);
}
