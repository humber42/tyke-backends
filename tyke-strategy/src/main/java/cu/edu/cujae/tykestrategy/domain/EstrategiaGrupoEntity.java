package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estrategia_grupo", schema = "public", catalog = "tyke-strategy")
public class EstrategiaGrupoEntity {
    private long idEstrategiaGrupo;
    private Long idGrupo;
    private EstrategiaEntity estrategia;

    @Id
    @Column(name = "id_estrategia_grupo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdEstrategiaGrupo() {
        return idEstrategiaGrupo;
    }

    public void setIdEstrategiaGrupo(long idEstrategiaGrupo) {
        this.idEstrategiaGrupo = idEstrategiaGrupo;
    }


    @Basic
    @Column(name = "id_grupo")
    public Long getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Long idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstrategiaGrupoEntity that = (EstrategiaGrupoEntity) o;
        return idEstrategiaGrupo == that.idEstrategiaGrupo &&
                Objects.equals(idGrupo, that.idGrupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstrategiaGrupo, idGrupo);
    }

    @ManyToOne
    @JoinColumn(name = "id_estrategia", referencedColumnName = "id_estrategia")
    public EstrategiaEntity getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(EstrategiaEntity estrategiaByIdEstrategia) {
        this.estrategia = estrategiaByIdEstrategia;
    }
}
