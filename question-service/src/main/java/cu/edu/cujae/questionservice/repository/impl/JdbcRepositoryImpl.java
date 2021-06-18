package cu.edu.cujae.questionservice.repository.impl;

import cu.edu.cujae.questionservice.dto.*;
import cu.edu.cujae.questionservice.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryImpl implements JdbcRepository {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public int savePreguntaRespuesta(PreguntaRespuestaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_pregunta",dto.getId_pregunta());
        source.addValue("id_respuesta",dto.getId_respuesta());
        source.addValue("correcta",dto.isCorrecta());
        source.addValue("pregunta_padre",dto.getPregunta_padre());
        source.addValue("orden",dto.getOrden());

        return namedParameterJdbcTemplate.update(
                "INSERT INTO \"pregunta_respuesta\" (id_pregunta, id_respuesta, correcta, pregunta_padre, orden)"
                + "VALUES (:id_pregunta, :id_respuesta, :correcta, :pregunta_padre, :orden)"
                ,source);
    }

    @Override
    public int saveBonificacion(BonificacionPreguntaTiempoDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_pregunta",dto.getIdPregunta());
        source.addValue("tiempo_menor",dto.getTiempoMenor());
        source.addValue("bonificacion",dto.getBonificacion());

        return namedParameterJdbcTemplate.update(
                "INSERT INTO \"bonificacion_pregunta_tiempo\"(id_pregunta, tiempo_menor, bonificacion)"
        +"VALUES (:id_pregunta, :tiempo_menor, :bonificacion)",source);
    }

    @Override
    public int saveTipoPregunta(TipoPreguntaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tipo",dto.getTipo());
        return namedParameterJdbcTemplate.update(
                "INSERT INTO \"tipo_pregunta\"(tipo)"+
                "VALUES (:tipo)",source);
    }

    @Override
    public int saveTipoPista(TipoPistaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("tipo",dto.getTipo());
        source.addValue("puntos_pista",dto.getPuntosPista());
        source.addValue("puntos_huego",dto.getPuntosJuego());
        return namedParameterJdbcTemplate.update(
                "Insert into \"tipo_pista\"(tipo, puntos_pista, puntos_juego)"+
                        "Values (:tipo, :puntos_pista, :puntos_juego)",
                source
        );
    }

    @Override
    public int saveRespuesta(RespuestaDto dto) {
        MapSqlParameterSource source =new MapSqlParameterSource();
        source.addValue("texto",dto.getTexto());
        source.addValue("puntuacion",dto.getPuntuación());
        return namedParameterJdbcTemplate.update(
                "Insert Into \"respuesta\"(texto, puntuacion)"+
                        "Values (:texto, :puntuacion)",source
        );
    }

    @Override
    public int saveProfileRespuesta(ProfileRespuestaPreguntaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_respuesta",dto.getIdRespuesta());
        source.addValue("id_pregunta",dto.getIdPregunta());
        source.addValue("tiempo_segundos",dto.getTiempoSegundos());
        source.addValue("username",dto.getUsername());
        return namedParameterJdbcTemplate.update(
                "Insert into \"profile_respuesta_pregunta\"(id_respuesta, id_pregunta, tiempo_segundos, username)"+
                        "VALUES (:id_respuesta,:id_pregunta,:tiempo_segundos,:username)",
                source
        );
    }

    @Override
    public int savePistaPregunta(PistaPreguntaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_pregunta",dto.getIdPregunta());
        source.addValue("id_pista",dto.getIdPista());
        return namedParameterJdbcTemplate.update(
                "Insert into \"pista_pregunta\"(id_pregunta,id_pista)"+
                        "Values (:id_pregunta,:id_pista)",source
        );
    }

    @Override
    public int savePista(PistaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("texto_ayuda",dto.getTextoAyuda());
        source.addValue("id_tipo_pista",dto.getIdTipoPista());
        return namedParameterJdbcTemplate.update(
                "Insert into \"pista\"(texto_ayuda,id_tipo_pista)"+
                "Values (:texto_ayuda,:id_tipo_pista)",source);
    }

    @Override
    public int savePregunta(PreguntaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("titulo_pregunta",dto.getTituloPregunta());
        source.addValue("id_tipo_pregunta",dto.getIdTipoPregunta());
        source.addValue("tiempo_en_segundos",dto.getTiempoEnSegundos());
        source.addValue("cant_puntos_completar_correctamente",dto.getCantPuntosCompletarCorrectamente());
        source.addValue("asignatura",dto.getAsignatura());
        return namedParameterJdbcTemplate.update(
                "Insert Into \"pregunta\"(titulo_pregunta,id_tipo_pregunta,tiempo_en_segundos,cant_puntos_completar_correctamente,asignatura)"+
                "Values(:titulo_pregunta,:id_tipo_pregunta,:tiempo_en_segundos,:cant_puntos_completar_correctamente,:asignatura)",source);
    }

    @Override
    public int saveFeedback(FeedbackDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("feedback",dto.getFeedback());
        source.addValue("id_pregunta",dto.getIdPregunta());
        source.addValue("username",dto.getUsername());
        return namedParameterJdbcTemplate.update(
                "Insert into \"feedback\" (feedback, id_pregunta, username)"+
                        "VALUES (:feedback,:id_pregunta,:username)"
        ,source);
    }



}
