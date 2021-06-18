package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "curso_anno", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(CursoAnnoEntityPK.class)
public class CursoAnnoEntity {
    private int idCurso;
    private int idAnno;
    private CursoEntity cursoByIdCurso;
    private AnnoEntity annoByIdAnno;

    @Id
    @Column(name = "id_curso")
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Id
    @Column(name = "id_anno")
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
        CursoAnnoEntity that = (CursoAnnoEntity) o;
        return idCurso == that.idCurso &&
                idAnno == that.idAnno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCurso, idAnno);
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }
}
