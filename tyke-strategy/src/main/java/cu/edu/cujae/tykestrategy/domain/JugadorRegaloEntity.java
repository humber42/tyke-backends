package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugador_regalo", schema = "public", catalog = "tyke-strategy")
public class JugadorRegaloEntity {
    private long idJugadorRegalos;
    private Long idJugador;
    private Integer cantidad;
    private RegaloEntity regalo;

    @Id
    @Column(name = "id_jugador_regalos")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdJugadorRegalos() {
        return idJugadorRegalos;
    }

    public void setIdJugadorRegalos(long idJugadorRegalos) {
        this.idJugadorRegalos = idJugadorRegalos;
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
    @Column(name = "cantidad")
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorRegaloEntity that = (JugadorRegaloEntity) o;
        return idJugadorRegalos == that.idJugadorRegalos &&

                Objects.equals(idJugador, that.idJugador) &&
                Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugadorRegalos, idJugador, cantidad);
    }

    @ManyToOne
    @JoinColumn(name = "id_regalo", referencedColumnName = "id_regalo")
    public RegaloEntity getRegalo() {
        return regalo;
    }

    public void setRegalo(RegaloEntity regaloByIdRegalo) {
        this.regalo = regaloByIdRegalo;
    }
}
