package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class AnnoGrupoEntityPK implements Serializable {
    private int idAnno;
    private int idGrupo;

    @Column(name = "id_anno")
    @Id
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Column(name = "id_grupo")
    @Id
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
        AnnoGrupoEntityPK that = (AnnoGrupoEntityPK) o;
        return idAnno == that.idAnno &&
                idGrupo == that.idGrupo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAnno, idGrupo);
    }
}
