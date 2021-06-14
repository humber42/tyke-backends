package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SemestreAsignaturaEntityPK implements Serializable {
    private Integer idSemestre;
    private Integer idAsignatura;

    @Column(name = "id_semestre")
    @Id
    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Column(name = "id_asignatura")
    @Id
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreAsignaturaEntityPK that = (SemestreAsignaturaEntityPK) o;
        return Objects.equals(idSemestre, that.idSemestre) &&
                Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemestre, idAsignatura);
    }
}
