package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugador_desafio", schema = "public", catalog = "tyke-strategy")
public class JugadorDesafioEntity {
    private long idJugadorDesafio;
    private Long idJugadorDesafiante;
    private Long idJugadorDesafiado;
    private Boolean desafioEntregado;
    private Boolean desafioConfirmado;
    private EstrategiaEntity estrategia;

    @Id
    @Column(name = "id_jugador_desafio")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdJugadorDesafio() {
        return idJugadorDesafio;
    }

    public void setIdJugadorDesafio(long idJugadorDesafio) {
        this.idJugadorDesafio = idJugadorDesafio;
    }

    @Basic
    @Column(name = "id_jugador_desafiante")
    public Long getIdJugadorDesafiante() {
        return idJugadorDesafiante;
    }

    public void setIdJugadorDesafiante(Long idJugadorDesafiante) {
        this.idJugadorDesafiante = idJugadorDesafiante;
    }

    @Basic
    @Column(name = "id_jugador_desafiado")
    public Long getIdJugadorDesafiado() {
        return idJugadorDesafiado;
    }

    public void setIdJugadorDesafiado(Long idJugadorDesafiado) {
        this.idJugadorDesafiado = idJugadorDesafiado;
    }

    @Basic
    @Column(name = "desafio_entregado")
    public Boolean getDesafioEntregado() {
        return desafioEntregado;
    }

    public void setDesafioEntregado(Boolean desafioEntregado) {
        this.desafioEntregado = desafioEntregado;
    }

    @Basic
    @Column(name = "desafio_confirmado")
    public Boolean getDesafioConfirmado() {
        return desafioConfirmado;
    }

    public void setDesafioConfirmado(Boolean desafioConfirmado) {
        this.desafioConfirmado = desafioConfirmado;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorDesafioEntity that = (JugadorDesafioEntity) o;
        return idJugadorDesafio == that.idJugadorDesafio &&
                Objects.equals(idJugadorDesafiante, that.idJugadorDesafiante) &&
                Objects.equals(idJugadorDesafiado, that.idJugadorDesafiado) &&
                Objects.equals(desafioEntregado, that.desafioEntregado) &&
                Objects.equals(desafioConfirmado, that.desafioConfirmado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugadorDesafio, idJugadorDesafiante, idJugadorDesafiado, desafioEntregado, desafioConfirmado);
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
