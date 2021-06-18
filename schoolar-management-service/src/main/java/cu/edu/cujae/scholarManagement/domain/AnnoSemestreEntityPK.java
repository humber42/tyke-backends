package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AnnoSemestreEntityPK implements Serializable {
    private int idAnno;
    private int idSemestre;

    @Column(name = "id_anno")
    @Id
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Column(name = "id_semestre")
    @Id
    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoSemestreEntityPK that = (AnnoSemestreEntityPK) o;
        return idAnno == that.idAnno &&
                idSemestre == that.idSemestre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idSemestre);
    }
}
