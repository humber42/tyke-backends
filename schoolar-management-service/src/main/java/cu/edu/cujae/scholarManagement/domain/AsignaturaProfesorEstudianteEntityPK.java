package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AsignaturaProfesorEstudianteEntityPK implements Serializable {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idEstudiante;

    @Column(name = "id_asignatura")
    @Id
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Column(name = "id_profesor")
    @Id
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Column(name = "id_estudiante")
    @Id
    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaProfesorEstudianteEntityPK that = (AsignaturaProfesorEstudianteEntityPK) o;
        return Objects.equals(idAsignatura, that.idAsignatura) &&
                Objects.equals(idProfesor, that.idProfesor) &&
                Objects.equals(idEstudiante, that.idEstudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idProfesor, idEstudiante);
    }
}
