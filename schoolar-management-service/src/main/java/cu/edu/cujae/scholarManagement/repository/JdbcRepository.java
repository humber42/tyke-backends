package cu.edu.cujae.scholarManagement.repository;

import cu.edu.cujae.scholarManagement.api.profesor.ProfesorRequestToUpdate;
import cu.edu.cujae.scholarManagement.dto.*;

public interface JdbcRepository {
    int saveAnnoGrupo(AnnoGrupoDto dto);
    int saveAnnoSemestre(AnnoSemestreDto dto);
    int saveAsignaturaProfesorGrupo(AsignaturaProfesorGrupoDto dto);
    int saveAsignaturaTema(AsignaturaTemaDto dto);
    int saveCursoAnno(CursoAnnoDto dto);
    int saveEstudianteGrupo(EstudianteGrupoDto dto);
    int saveFacultadCurso(FacultadCursoDto dto);
    int saveSemestreAsignatura(SemestreAsignaturaDto dto);
    int saveSignatureFaculty(SignatureCarreraDto dto);
    int deleteSignatureFaculty(long id);
    int updateProfesor(ProfesorRequestToUpdate profesorToUpdate,int facultad);


}
