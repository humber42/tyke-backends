package cu.edu.cujae.scholarManagement.repository.impl;

import cu.edu.cujae.scholarManagement.dto.*;
import cu.edu.cujae.scholarManagement.repository.JdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcRepositoryImpl implements JdbcRepository {

    @Autowired
    NamedParameterJdbcTemplate template;

    @Override
    public int saveAnnoGrupo(AnnoGrupoDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_anno",dto.getIdAnno());
        source.addValue("id_grupo",dto.getIdGrupo());
        return template.update(
                "INSERT into \"anno_grupo\"(id_anno,id_grupo)"+
                "VALUES(:id_anno,:id_grupo)",source);
    }

    @Override
    public int saveAnnoSemestre(AnnoSemestreDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_anno",dto.getIdAnno());
        source.addValue("id_semestre",dto.getIdSemestre());

        return template.update(
                "INSERT INTO \"anno_semestre\"(id_anno, id_semestre)"+
                "VALUES(:id_anno,:id_semestre)",source
        );
    }

    @Override
    public int saveAsignaturaProfesorEstudiante(AsignaturaProfesorEstudianteDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_asignatura",dto.getIdAsignatura());
        source.addValue("id_profesor",dto.getIdProfesor());
        source.addValue("id_estudiante",dto.getIdEstudiante());
        return template.update(
                "INSERT INTO \"asignatura_profesor_estudiante\"(id_asignatura, id_profesor, id_estudiante)"+
                        "VALUES(:id_asignatura,:id_profesor,:id_estudiante)"
                ,source);
    }

    @Override
    public int saveAsignaturaTema(AsignaturaTemaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_asignatura",dto.getIdAsignatura());
        source.addValue("id_tema",dto.getIdTema());
        return template.update(
                "INSERT INTO \"asignatura_tema\"(id_asignatura,id_tema)" +
                        "VALUES(:id_asignatura,:id_tema)",source
        );
    }

    @Override
    public int saveCursoAnno(CursoAnnoDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_curso",dto.getIdCurso());
        source.addValue("id_anno",dto.getIdAnno());
        return template.update(
                "INSERT INTO \"curso_anno\"(id_curso, id_anno) VALUES(:id_curso,:id_anno)"
                ,source);
    }

    @Override
    public int saveEstudianteGrupo(EstudianteGrupoDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_estudiante",dto.getIdEstudiante());
        source.addValue("id_grupo",dto.getIdGrupo());
        source.addValue("id_curso",dto.getIdCurso());
        source.addValue("id_anno",dto.getIdAnno());
        return template.update(
                "INSERT INTO \"estudiante_grupo\"(id_estudiante, id_grupo, id_curso, id_anno) " +
                        "VALUES(:id_estudiante,:id_grupo,:id_curso,:id_anno)"
                ,source);
    }

    @Override
    public int saveFacultadCurso(FacultadCursoDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_facultad",dto.getIdFacultad());
        source.addValue("id_curso",dto.getIdCurso());
        return template.update(
                "INSERT INTO \"facultad_curso\"(id_facultad, id_curso) " +
                        "VALUES(:id_facultad,:id_curso)"
                ,source);
    }

    @Override
    public int saveSemestreAsignatura(SemestreAsignaturaDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_semestre",dto.getIdSemestre());
        source.addValue("id_asignatura",dto.getIdAsignatura());
        return template.update(
                "INSERT INTO \"semestre_asignatura\"(id_semestre, id_asignatura) " +
                        "VALUES(:id_semestre,:id_asignatura)"
                ,source);
    }

    @Override
    public int saveSignatureFaculty(SignatureCarreraDto dto) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id_faculty",dto.getIdFaculty());
        source.addValue("id_signature",dto.getIdSignature());
        return template.update(
                "INSERT INTO \"signature_faculty\"(id_faculty, id_signature)" +
                        "VALUES (:id_faculty,:id_signature)"
                ,source);

    }

    @Override
    public int deleteSignatureFaculty(long id) {
        MapSqlParameterSource source = new MapSqlParameterSource();
        source.addValue("id",id);
        return template.update(
                "DELETE FROM \"signature_faculty\"" +
                        "where id = :id",source);
    }

}
