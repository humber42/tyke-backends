package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "anno_grupo", schema = "public", catalog = "tyke-schoolar-management")

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AnnoGrupoEntity implements Serializable {
    private Integer idAnno;
    private Integer idGrupo;
    private AnnoEntity annoByIdAnno;
    private GrupoEntity grupoByIdGrupo;

    @Id
    @Column(name = "id_anno")
    public Integer getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(Integer idAnno) {
        this.idAnno = idAnno;
    }

    @Id
    @Column(name = "id_grupo")
    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoGrupoEntity that = (AnnoGrupoEntity) o;
        return Objects.equals(idAnno, that.idAnno) &&
                Objects.equals(idGrupo, that.idGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idGrupo);
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
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", nullable = false)
    public GrupoEntity getGrupoByIdGrupo() {
        return grupoByIdGrupo;
    }

    public void setGrupoByIdGrupo(GrupoEntity grupoByIdGrupo) {
        this.grupoByIdGrupo = grupoByIdGrupo;
    }
}
