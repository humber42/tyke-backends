package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_pista", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class TipoPistaEntity implements Serializable {

    private long id;
    private String tipo;
    private Integer puntosPista;
    private Integer puntosJuego;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "puntos_pista")
    public Integer getPuntosPista() {
        return puntosPista;
    }

    public void setPuntosPista(Integer puntosPista) {
        this.puntosPista = puntosPista;
    }

    @Basic
    @Column(name = "puntos_juego")
    public Integer getPuntosJuego() {
        return puntosJuego;
    }

    public void setPuntosJuego(Integer puntosJuego) {
        this.puntosJuego = puntosJuego;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPistaEntity that = (TipoPistaEntity) o;

        if (id != that.id) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (puntosPista != null ? !puntosPista.equals(that.puntosPista) : that.puntosPista != null) return false;
        if (puntosJuego != null ? !puntosJuego.equals(that.puntosJuego) : that.puntosJuego != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (puntosPista != null ? puntosPista.hashCode() : 0);
        result = 31 * result + (puntosJuego != null ? puntosJuego.hashCode() : 0);
        return result;
    }
}
