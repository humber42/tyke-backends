package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_pista", schema = "public", catalog = "tyke-questions")
public class TipoPistaEntity {
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
        return id == that.id &&
                Objects.equals(tipo, that.tipo) &&
                Objects.equals(puntosPista, that.puntosPista) &&
                Objects.equals(puntosJuego, that.puntosJuego);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo, puntosPista, puntosJuego);
    }

}
