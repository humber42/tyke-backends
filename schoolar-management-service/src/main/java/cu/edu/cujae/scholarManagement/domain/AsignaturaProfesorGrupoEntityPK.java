package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AsignaturaProfesorGrupoEntityPK implements Serializable {
    private int idAsignatura;
    private int idProfesor;
    private int idGrupo;

    @Column(name = "id_asignatura")
    @Id
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Column(name = "id_profesor")
    @Id
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Column(name = "id_grupo")
    @Id
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaProfesorGrupoEntityPK that = (AsignaturaProfesorGrupoEntityPK) o;
        return idAsignatura == that.idAsignatura &&
                idProfesor == that.idProfesor &&
                idGrupo == that.idGrupo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idProfesor, idGrupo);
    }
}
