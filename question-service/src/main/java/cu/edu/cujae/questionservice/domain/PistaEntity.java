package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pista", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PistaEntity implements Serializable {

    private long id;
    private String textoAyuda;
    private TipoPistaEntity tipoPistaByIdTipoPista;

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
    @Column(name = "texto_ayuda")
    public String getTextoAyuda() {
        return textoAyuda;
    }

    public void setTextoAyuda(String textoAyuda) {
        this.textoAyuda = textoAyuda;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PistaEntity that = (PistaEntity) o;

        if (id != that.id) return false;
        if (textoAyuda != null ? !textoAyuda.equals(that.textoAyuda) : that.textoAyuda != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (textoAyuda != null ? textoAyuda.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_pista", referencedColumnName = "id", nullable = false)
    public TipoPistaEntity getTipoPistaByIdTipoPista() {
        return tipoPistaByIdTipoPista;
    }

    public void setTipoPistaByIdTipoPista(TipoPistaEntity tipoPistaByIdTipoPista) {
        this.tipoPistaByIdTipoPista = tipoPistaByIdTipoPista;
    }
}
