package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FacultadCursoEntityPK implements Serializable {
    private Integer idFacultad;
    private Integer idCurso;

    @Column(name = "id_facultad")
    @Id
    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Column(name = "id_curso")
    @Id
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadCursoEntityPK that = (FacultadCursoEntityPK) o;
        return Objects.equals(idFacultad, that.idFacultad) &&
                Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacultad, idCurso);
    }
}
