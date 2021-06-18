package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SemestreAsignaturaEntityPK implements Serializable {
    private int idSemestre;
    private int idAsignatura;

    @Column(name = "id_semestre")
    @Id
    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Column(name = "id_asignatura")
    @Id
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreAsignaturaEntityPK that = (SemestreAsignaturaEntityPK) o;
        return idSemestre == that.idSemestre &&
                idAsignatura == that.idAsignatura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemestre, idAsignatura);
    }
}
