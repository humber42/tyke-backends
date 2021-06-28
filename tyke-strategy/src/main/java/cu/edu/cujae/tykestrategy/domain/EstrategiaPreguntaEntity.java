package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estrategia_pregunta", schema = "public", catalog = "tyke-strategy")
public class EstrategiaPreguntaEntity {
    private int id;
    private Long idPregunta;
    private Long idEstrategia;
    private EstrategiaEntity estrategiaByIdEstrategia;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_pregunta")
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "id_estrategia")
    public Long getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(Long idEstrategia) {
        this.idEstrategia = idEstrategia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstrategiaPreguntaEntity that = (EstrategiaPreguntaEntity) o;
        return id == that.id &&
                Objects.equals(idPregunta, that.idPregunta) &&
                Objects.equals(idEstrategia, that.idEstrategia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPregunta, idEstrategia);
    }

    @ManyToOne
    @JoinColumn(name = "id_estrategia", referencedColumnName = "id_estrategia",insertable = false,updatable = false)
    public EstrategiaEntity getEstrategiaByIdEstrategia() {
        return estrategiaByIdEstrategia;
    }

    public void setEstrategiaByIdEstrategia(EstrategiaEntity estrategiaByIdEstrategia) {
        this.estrategiaByIdEstrategia = estrategiaByIdEstrategia;
    }
}
