package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugador_estrategia", schema = "public", catalog = "tyke-strategy")
public class JugadorEstrategiaEntity {
    private long idJugadorEstrategia;
    private Long idJugador;
    private Integer puntuacionObtenida;
    private Boolean completada;
    private EstrategiaEntity estrategia;

    @Id
    @Column(name = "id_jugador_estrategia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdJugadorEstrategia() {
        return idJugadorEstrategia;
    }

    public void setIdJugadorEstrategia(long idJugadorEstrategia) {
        this.idJugadorEstrategia = idJugadorEstrategia;
    }


    @Basic
    @Column(name = "id_jugador")
    public Long getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(Long idJugador) {
        this.idJugador = idJugador;
    }

    @Basic
    @Column(name = "puntuacion_obtenida")
    public Integer getPuntuacionObtenida() {
        return puntuacionObtenida;
    }

    public void setPuntuacionObtenida(Integer puntuacionObtenida) {
        this.puntuacionObtenida = puntuacionObtenida;
    }

    @Basic
    @Column(name = "completada")
    public Boolean getCompletada() {
        return completada;
    }

    public void setCompletada(Boolean completada) {
        this.completada = completada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorEstrategiaEntity that = (JugadorEstrategiaEntity) o;
        return idJugadorEstrategia == that.idJugadorEstrategia &&
                Objects.equals(idJugador, that.idJugador) &&
                Objects.equals(puntuacionObtenida, that.puntuacionObtenida) &&
                Objects.equals(completada, that.completada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugadorEstrategia, idJugador, puntuacionObtenida, completada);
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
