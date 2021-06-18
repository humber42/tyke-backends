package cu.edu.cujae.tykestrategy.repository;

import cu.edu.cujae.tykestrategy.dto.*;

public interface JdbcSaveRepository {
    int saveStrategy(EstrategiaDto dto);
    int saveStrategyTema(EstrategiaTemaDto dto);
    int saveStrategyGrupo(EstrategiaGrupoDto dto);
    int saveInsignia(InsigniaDto dto);
    int saveJugadorDesafio(JugadorDesafioDto dto);
    int saveJugadorEstratgiaDto(JugadorEstrategiaDto dto);
    int saveJugadorInsigniaDto(JugadorInsigniaDto dto);
    int saveJugadorRegaloDto(JugadorRegaloDto dto);
    int saveRegalo(RegaloDto dto);
}
