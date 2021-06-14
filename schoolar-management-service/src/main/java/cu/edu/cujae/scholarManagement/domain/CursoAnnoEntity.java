package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "curso_anno", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)

public class CursoAnnoEntity implements Serializable {
    private Integer idCurso;
    private Integer idAnno;
    private CursoEntity cursoByIdCurso;
    private AnnoEntity annoByIdAnno;

    @Id
    @Column(name = "id_curso")
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Id
    @Column(name = "id_anno")
    public Integer getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(Integer idAnno) {
        this.idAnno = idAnno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoAnnoEntity that = (CursoAnnoEntity) o;
        return Objects.equals(idCurso, that.idCurso) &&
                Objects.equals(idAnno, that.idAnno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idAnno);
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }
}
