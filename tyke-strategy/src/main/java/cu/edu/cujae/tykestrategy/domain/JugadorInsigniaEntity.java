package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "jugador_insignia", schema = "public", catalog = "tyke-strategy")
public class JugadorInsigniaEntity {
    private long idJugadorInsignias;
    private Long idJugador;
    private Integer nivelAvance;
    private InsigniaEntity insignia;

    @Id
    @Column(name = "id_jugador_insignias")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdJugadorInsignias() {
        return idJugadorInsignias;
    }

    public void setIdJugadorInsignias(long idJugadorInsignias) {
        this.idJugadorInsignias = idJugadorInsignias;
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
    @Column(name = "nivel_avance")
    public Integer getNivelAvance() {
        return nivelAvance;
    }

    public void setNivelAvance(Integer nivelAvance) {
        this.nivelAvance = nivelAvance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JugadorInsigniaEntity that = (JugadorInsigniaEntity) o;
        return idJugadorInsignias == that.idJugadorInsignias &&
                Objects.equals(idJugador, that.idJugador) &&
                Objects.equals(nivelAvance, that.nivelAvance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugadorInsignias, idJugador, nivelAvance);
    }

    @ManyToOne
    @JoinColumn(name = "id_insignia", referencedColumnName = "id_insignia")
    public InsigniaEntity getInsignia() {
        return insignia;
    }

    public void setInsignia(InsigniaEntity insigniaByIdInsignia) {
        this.insignia = insigniaByIdInsignia;
    }
}
