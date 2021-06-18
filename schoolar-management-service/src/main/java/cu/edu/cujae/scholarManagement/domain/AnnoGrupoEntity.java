package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "anno_grupo", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AnnoGrupoEntityPK.class)
public class AnnoGrupoEntity {
    private int idAnno;
    private int idGrupo;
    private AnnoEntity annoByIdAnno;
    private GrupoEntity grupoByIdGrupo;

    @Id
    @Column(name = "id_anno")
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Id
    @Column(name = "id_grupo")
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoGrupoEntity that = (AnnoGrupoEntity) o;
        return idAnno == that.idAnno &&
                idGrupo == that.idGrupo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idGrupo);
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
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public GrupoEntity getGrupoByIdGrupo() {
        return grupoByIdGrupo;
    }

    public void setGrupoByIdGrupo(GrupoEntity grupoByIdGrupo) {
        this.grupoByIdGrupo = grupoByIdGrupo;
    }
}
