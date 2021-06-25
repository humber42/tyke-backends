package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pista", schema = "public", catalog = "tyke-questions")
public class PistaEntity {
    private long id;
    private String textoAyuda;
    private int idTipoPista;
    private TipoPistaEntity tipoPistaByIdTipoPista;
    private Collection<PistaPreguntaEntity> pistaPreguntasById;

    @Id
    @Column(name = "id")
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

    @Basic
    @Column(name = "id_tipo_pista")
    public int getIdTipoPista() {
        return idTipoPista;
    }

    public void setIdTipoPista(int idTipoPista) {
        this.idTipoPista = idTipoPista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PistaEntity that = (PistaEntity) o;
        return id == that.id &&
                idTipoPista == that.idTipoPista &&
                Objects.equals(textoAyuda, that.textoAyuda);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textoAyuda, idTipoPista);
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_pista", referencedColumnName = "id", nullable = false)
    public TipoPistaEntity getTipoPistaByIdTipoPista() {
        return tipoPistaByIdTipoPista;
    }

    public void setTipoPistaByIdTipoPista(TipoPistaEntity tipoPistaByIdTipoPista) {
        this.tipoPistaByIdTipoPista = tipoPistaByIdTipoPista;
    }

    @OneToMany(mappedBy = "pistaByIdPista")
    public Collection<PistaPreguntaEntity> getPistaPreguntasById() {
        return pistaPreguntasById;
    }

    public void setPistaPreguntasById(Collection<PistaPreguntaEntity> pistaPreguntasById) {
        this.pistaPreguntasById = pistaPreguntasById;
    }
}
