package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class FacultadCursoEntityPK implements Serializable {
    private int idFacultad;
    private int idCurso;

    @Column(name = "id_facultad")
    @Id
    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Column(name = "id_curso")
    @Id
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadCursoEntityPK that = (FacultadCursoEntityPK) o;
        return idFacultad == that.idFacultad &&
                idCurso == that.idCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacultad, idCurso);
    }
}
