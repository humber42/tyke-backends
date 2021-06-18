package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AsignaturaTemaEntityPK implements Serializable {
    private int idAsignatura;
    private int idTema;

    @Column(name = "id_asignatura")
    @Id
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Column(name = "id_tema")
    @Id
    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaTemaEntityPK that = (AsignaturaTemaEntityPK) o;
        return idAsignatura == that.idAsignatura &&
                idTema == that.idTema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idTema);
    }
}
