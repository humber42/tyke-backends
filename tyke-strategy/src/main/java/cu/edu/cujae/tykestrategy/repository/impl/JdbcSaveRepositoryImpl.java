package cu.edu.cujae.tykestrategy.repository.impl;

import cu.edu.cujae.tykestrategy.dto.*;
import cu.edu.cujae.tykestrategy.repository.JdbcSaveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcSaveRepositoryImpl implements JdbcSaveRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    @Override
    public int saveInsignia(InsigniaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("nombre",dto.getNombre());
        source.addValue("puntos_avance",dto.getPuntosAvance());
        source.addValue("id_rol",dto.getIdRolProfesional());
        source.addValue("puntos_otorgar",dto.getPuntosOtorgar());
        return template.update(
                "Insert into \"insignia\"(nombre,puntos_avance,id_rol,puntos_otorgar)"+
                        "Values(:nombre,:puntos_avance,:id_rol,:puntos_otorgar)",source
        );
    }

    @Override
    public int saveJugadorDesafio(JugadorDesafioDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_jugador_desafiante",dto.getIdJugadorDesafiante());
        source.addValue("id_jugador_desafiado",dto.getIdJugadorDesafiado());
        source.addValue("desafio_entregado",dto.getDesafioEntregado());
        source.addValue("desafio_confirmado",dto.getDesafioConfirmado());
        source.addValue("id_estrategia",dto.getIdEstrategia());

        return template.update(
                "INSERT into \"jugador_desafio\"(id_jugador_desafiante, id_jugador_desafiado, desafio_entregado, desafio_confirmado, id_estrategia) " +
                        "VALUES(:id_jugador_desafiante,:id_jugador_desafiado,:desafio_entregado,:desafio_confirmado,:id_estrategia) "
                ,source);
    }

    @Override
    public int saveJugadorEstratgiaDto(JugadorEstrategiaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_estrategia",dto.getIdEstrategia());
        source.addValue("id_jugador",dto.getIdJugador());
        source.addValue("puntuacion_obtenida",dto.getPuntuacionObtenida());
        source.addValue("completada",dto.getCompletada());

        return template.update(
                "INSERT INTO \"jugador_estrategia\"(id_estrategia, id_jugador, puntuacion_obtenida, completada) " +
                        "VALUES(:id_estrategia,:id_jugador,:puntuacion_obtenida,:completada)"
                ,source);
    }

    @Override
    public int saveJugadorRegaloDto(JugadorRegaloDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_regalo",dto.getIdRegalo());
        source.addValue("id_jugador",dto.getIdJugador());
        source.addValue("cantidad",dto.getCantidad());
        return template.update(
                "INSERT INTO \"jugador_regalo\"(id_regalo, id_jugador, cantidad) " +
                        "VALUES(:id_regalo,:id_jugador,:cantidad) "
                ,source);
    }

    @Override
    public int saveRegalo(RegaloDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_tipo_regalo",dto.getIdTipoRegalo());
        source.addValue("id_otorgamiento",dto.getIdOtorgamiento());
        source.addValue("descripcion",dto.getDescripcion());

        return template.update(
                "INSERT INTO \"regalo\"(id_tipo_regalo, id_otorgamiento, descripcion) " +
                        "VALUES(:id_tipo_regalo,:id_otorgamiento,:descripcion)"
                ,source);
    }

    @Override
    public int saveStrategy(EstrategiaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("puntos",dto.getPuntos());
        source.addValue("nombre",dto.getNombre());
        source.addValue("fecha",dto.getFecha());
        source.addValue("id_profesor",dto.getIdProfesor());
        source.addValue("habilitada",dto.getHabilitada());
        source.addValue("evaluada",dto.getEvaluada());

        return template.update("INSERT INTO \"estrategia\"(puntos, nombre, fecha , id_profesor, habilitada, evaluada) " +
                "VALUES(:puntos,:nombre,:fecha,:id_profesor,:habilitada,:evaluada)"
                ,source);
    }

    @Override
    public int saveStrategyGrupo(EstrategiaGrupoDto dto) {
       MapSqlParameterSource source = new MapSqlParameterSource();
       source.addValue("id_estrategia",dto.getIdEstrategia());
       source.addValue("id_grupo",dto.getIdGrupo());

       return template.update("INSERT into \"estrategia_grupo\"(id_estrategia, id_grupo) " +
                       "VALUES(:id_estrategia,:id_grupo)"
               ,source);
    }

    @Override
    public int saveStrategyTema(EstrategiaTemaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_estrategia",dto.getIdEstrategia());
        source.addValue("id_tema",dto.getIdTema());

        return template.update(
                "INSERT INTO \"estrategia_tema\"(id_estrategia, id_tema) " +
                        "VALUES(:id_estrategia,:id_tema) "
                ,source);
    }

    @Override
    public int saveJugadorInsigniaDto(JugadorInsigniaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_insignia",dto.getIdInsignia());
        source.addValue("id_jugador",dto.getIdJugador());
        source.addValue("nivel_alcance",dto.getNivelAvance());

        return template.update(
                "INSERT INTO \"jugador_insignia\"(id_insignia, id_jugador, nivel_avance) " +
                        "VALUES (:id_insignia,:id_jugador,:nivel_alcance)"
                ,source);
    }
}
