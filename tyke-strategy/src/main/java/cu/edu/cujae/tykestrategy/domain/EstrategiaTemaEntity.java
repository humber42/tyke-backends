package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estrategia_tema", schema = "public", catalog = "tyke-strategy")
public class EstrategiaTemaEntity {
    private long idEstrategiaTema;
    private Long idTema;
    private EstrategiaEntity estrategia;

    @Id
    @Column(name = "id_estrategia_tema")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdEstrategiaTema() {
        return idEstrategiaTema;
    }

    public void setIdEstrategiaTema(long idEstrategiaTema) {
        this.idEstrategiaTema = idEstrategiaTema;
    }


    @Basic
    @Column(name = "id_tema")
    public Long getIdTema() {
        return idTema;
    }

    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstrategiaTemaEntity that = (EstrategiaTemaEntity) o;
        return idEstrategiaTema == that.idEstrategiaTema &&
                Objects.equals(idTema, that.idTema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstrategiaTema, idTema);
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
