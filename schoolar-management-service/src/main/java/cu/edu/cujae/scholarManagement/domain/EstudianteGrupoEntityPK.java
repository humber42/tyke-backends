package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class EstudianteGrupoEntityPK implements Serializable {
    private int idEstudiante;
    private int idGrupo;
    private int idCurso;
    private int idAnno;

    @Column(name = "id_estudiante")
    @Id
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Column(name = "id_grupo")
    @Id
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Column(name = "id_curso")
    @Id
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Column(name = "id_anno")
    @Id
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteGrupoEntityPK that = (EstudianteGrupoEntityPK) o;
        return idEstudiante == that.idEstudiante &&
                idGrupo == that.idGrupo &&
                idCurso == that.idCurso &&
                idAnno == that.idAnno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idGrupo, idCurso, idAnno);
    }
}
