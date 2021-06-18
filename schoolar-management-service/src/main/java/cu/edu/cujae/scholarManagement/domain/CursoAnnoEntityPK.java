package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CursoAnnoEntityPK implements Serializable {
    private int idCurso;
    private int idAnno;

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
        CursoAnnoEntityPK that = (CursoAnnoEntityPK) o;
        return idCurso == that.idCurso &&
                idAnno == that.idAnno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idAnno);
    }
}
