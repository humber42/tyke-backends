package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anno_semestre", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AnnoSemestreEntityPK.class)
public class AnnoSemestreEntity {
    private int idAnno;
    private int idSemestre;
    private AnnoEntity annoByIdAnno;
    private SemestreEntity semestreByIdSemestre;

    @Id
    @Column(name = "id_anno")
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Id
    @Column(name = "id_semestre")
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
        AnnoSemestreEntity that = (AnnoSemestreEntity) o;
        return idAnno == that.idAnno &&
                idSemestre == that.idSemestre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idSemestre);
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }

    @ManyToOne
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public SemestreEntity getSemestreByIdSemestre() {
        return semestreByIdSemestre;
    }

    public void setSemestreByIdSemestre(SemestreEntity semestreByIdSemestre) {
        this.semestreByIdSemestre = semestreByIdSemestre;
    }
}
