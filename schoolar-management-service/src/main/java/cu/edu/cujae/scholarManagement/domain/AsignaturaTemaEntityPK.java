package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AsignaturaTemaEntityPK implements Serializable {
    private Integer idAsignatura;
    private Integer idTema;

    @Column(name = "id_asignatura")
    @Id
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Column(name = "id_tema")
    @Id
    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaTemaEntityPK that = (AsignaturaTemaEntityPK) o;
        return Objects.equals(idAsignatura, that.idAsignatura) &&
                Objects.equals(idTema, that.idTema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idTema);
    }
}
