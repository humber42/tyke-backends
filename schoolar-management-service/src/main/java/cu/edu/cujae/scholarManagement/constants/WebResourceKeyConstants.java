package cu.edu.cujae.scholarManagement.constants;

public class WebResourceKeyConstants {

    public static final String ASIGNATURA_URL = "/api/asignatura";
    public static final String ESTUDIANTE_URL = "/api/estudiante";
    public static final String ANNO_URL = "/api/anno";
    public static final String CARRERA_URL = "/api/carrera";
    public static final String FACULTAD_URL = "/api/facultad";
    public static final String CURSO_URL = "/api/curso";
    public static final String GRUPO_URL = "/api/grupo";
    public static final String PROFESOR_URL = "/api/profesor";
    public static final String SEMESTRE_URL = "/api/semestre";
    public static final String TEMA_URL = "/api/tema";

    //Compositions
    public static final String ANNO_GRUPO_URL = "/api/anno-grupo";
    public static final String ANNO_SEMESTRE_URL = "/api/anno-semestre";
    public static final String ASIGNATURA_PROFESOR_ESTUDIANTE_URL = "/api/asignatura-profesor-estudiante";
    public static final String ASIGNATURA_TEMA_URL = "/api/asignatura-tema";
    public static final String CURSO_ANNO_URL = "/api/curso-anno";
    public static final String ESTUDIANTE_GRUPO_URL = "/api/estudiante-grupo";
    public static final String FACULTAD_CURSO_URL = "/api/facultad-curso";
    public static final String SEMESTRE_ASIGNATURA_URL = "/api/semestre-asignatura";
    public static final String SIGNATURE_CAREER ="/api/signature-career";

    public interface AsignaturaUrls{
          String ASIGNATURA_SAVE = "/save";
          String ASIGNATURA_UPDATE = "/update";
          String ASIGNATURA_GET_ONE_BY_NAME = "/name";
          String ASIGNATURA_DELETE_BY_NAME ="/delete/name";
          String ASIGNATURA_ACTIVE ="/active";
          String ASIGNATURA_GET_BY_ID = "/id/{id}";
          String ASIGNATURA_GET_BY_NAME_PATH = "/name/{name}";
          
    }

    public interface AnnoUrls{
        String ANNO_SAVE = "/save";
        String ANNO_UPDATE = "/update";
        String ANNO_GET_ONE_BY_ANNO = "/anno";
        String ANNO_DELETE_ANNO_BY_ANNO ="/delete/anno";
    }

    public interface CarreraUrls{
        String CARRERA_SAVE = "/save";
        String CARRERA_BY_ID = "/id";
        String CARRERA_BY_NAME = "/name";
        String CARRERA_BY_SIGLAS = "/siglas";
        String CARRERA_UPDATE = "/update";
        String CARRERA_DELETE_BY_NAME ="/delete/name";
        String CARRERA_DELETE_BY_ID = "/delete/id";
        String CARRERA_FIND_ALL_IN_FACULTY = "/all/facultad";
    }

    public interface FacultadUrls{
        String FACULTAD_GET_BY_NAME = "/name";
        String FACULTAD_GET_BY_SIGLAS = "/siglas";
        String FACULTAD_GET_BY_ID = "/id";
        String FACUlTAD_SAVE = "/save";
        String FACULTAD_UPDATE = "/update";
        String FACULTAD_DELETE_BY_NAME = "/delete/name";
        String FACULTAD_DELETE_BY_ID = "/delete/id";
    }

    public interface CursoUrls{
        String CURSO_GET_BY_ID = "/id";
        String CURSO_GET_BY_NAME = "/name";
        String CURSO_GET_ACTIVE = "/active";
        String CURSO_SAVE = "/save";
        String CURSO_UPDATE = "/update";
        String CURSO_DELETE_BY_NAME = "/delete/name";
        String CURSO_DELETE_BY_ID = "/delete/id";
    }

    public interface EstudianteUrls{
        String ESTUDIANTE_FETCH_ALL_BY_FACULTY="/id-faculty";
        String ESTUDIANTE_GET_BY_ID ="/id";
        String ESTUDIANTE_SAVE = "/save";
        String ESTUDIANTE_UPDATE = "/update";
        String ESTUDIANTE_DELETE_BY_ID = "/delete/id";

    }

    public interface GrupoUrls{
        String GRUPO_GET_BY_ID = "/id";
        String GRUPO_GET_BY_NAME = "/name";
        String GRUPO_DELETE_BY_ID = "/id";
        String GRUPO_DELETE_BY_NAME = "/name";
        String GRUPO_SAVE = "/save";
        String GRUPO_UPDATE= "/update";

    }
    public interface ProfesorUrls{
        String PROFESOR_GET_BY_ID="/id";
        String PROFESOR_GET_BY_FULLNAME="/fullname";
        String PROFESOR_GET_BY_EMAIL="/email";
        String PROFESOR_SAVE="/save";
        String PROFESOR_UPDATE="/update";
        String PROFESOR_DELETE_BY_ID="/delete/id";
        String PROFESOR_DELETE_BY_FULLNAME="/delete/fullname";
        String PROFESOR_DELETE_BY_EMAIL="/delete/email";
    }

    public interface SemestreUrls{
        String SEMESTRE_GET_BY_ID="/id";
        String SEMESTRE_GET_BY_NAME="/name";
        String SEMESTRE_GET_ACTIVE="/active";
        String SEMESTRE_UPDATE="/update";
        String SEMESTRE_SAVE="/save";
        String SEMESTRE_DELETE_BY_ID="/delete/id";
        String SEMESTRE_DELETE_BY_NAME="/delete/name";
    }

    public interface TemaUrls{
        String TEMA_GET_BY_ID="/id";
        String TEMA_GET_BY_NAME="/name";
        String TEMA_UPDATE="/update";
        String TEMA_SAVE="/save";
        String TEMA_DELETE_BY_ID="/delete/id";
        String TEMA_DELETE_BY_NAME="/delete/name";
    }

    //Compositions
    public interface AnnoGrupoUrls{
        String ANNO_GRUPO_SAVE = "/save";
    }
    public interface AnnoSemestreUrls{
        String ANNO_SEMESTRE_SAVE = "/save";
    }
    public interface AsignaturaProfesorEstudianteUrls{
        String ASIGNATURA_PROFESOR_ESTUDIANTE_SAVE = "/save";
    }
    public interface AsignaturaTemaUrls{
        String ASIGANTURA_TEMA_SAVE = "/save";
    }
    public interface CursoAnnoUrls{
        String CURSO_ANNO_SAVE = "/save";
    }
    public interface EstudianteGrupoUrls{
        String ESTUDIANTE_GRUPO_SAVE = "/save";
    }
    public interface FacultadCursoUrls{
        String FACULTAD_CURSO_SAVE = "/save";
    }
    public interface SemestreAsignaturaUrls{
        String SEMESTRE_ASIGNATURA_SAVE = "/save";
    }
    public interface SignatureFacultyUrls{
        String SIGNATURE_FACULTY_SAVE="/save";
        String SIGNATURE_FACULTY_DELETE="/delete/{id}";
    }

}
