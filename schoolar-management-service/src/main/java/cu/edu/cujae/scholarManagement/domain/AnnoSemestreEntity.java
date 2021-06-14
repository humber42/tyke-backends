package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "anno_semestre", schema = "public", catalog = "tyke-schoolar-management")

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AnnoSemestreEntity implements Serializable {
    private Integer idAnno;
    private Integer idSemestre;
    private AnnoEntity annoByIdAnno;
    private SemestreEntity semestreByIdSemestre;

    @Id
    @Column(name = "id_anno")
    public Integer getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(Integer idAnno) {
        this.idAnno = idAnno;
    }

    @Id
    @Column(name = "id_semestre")
    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoSemestreEntity that = (AnnoSemestreEntity) o;
        return Objects.equals(idAnno, that.idAnno) &&
                Objects.equals(idSemestre, that.idSemestre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idSemestre);
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }

    @ManyToOne
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false)
    public SemestreEntity getSemestreByIdSemestre() {
        return semestreByIdSemestre;
    }

    public void setSemestreByIdSemestre(SemestreEntity semestreByIdSemestre) {
        this.semestreByIdSemestre = semestreByIdSemestre;
    }
}
