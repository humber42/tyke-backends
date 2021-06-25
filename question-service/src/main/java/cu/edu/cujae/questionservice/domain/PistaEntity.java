package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pista", schema = "public", catalog = "tyke-questions")
public class PistaEntity {
    private long id;
    private String textoAyuda;
    private int idTipoPista;
    private Long idPregunta;
    private TipoPistaEntity tipoPistaByIdTipoPista;
    private PreguntaEntity preguntaByIdPregunta;

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

    @Basic
    @Column(name = "id_tipo_pista")
    public int getIdTipoPista() {
        return idTipoPista;
    }

    public void setIdTipoPista(int idTipoPista) {
        this.idTipoPista = idTipoPista;
    }

    @Basic
    @Column(name = "id_pregunta")
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PistaEntity that = (PistaEntity) o;
        return id == that.id &&
                idTipoPista == that.idTipoPista &&
                Objects.equals(textoAyuda, that.textoAyuda) &&
                Objects.equals(idPregunta, that.idPregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, textoAyuda, idTipoPista, idPregunta);
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_pista", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public TipoPistaEntity getTipoPistaByIdTipoPista() {
        return tipoPistaByIdTipoPista;
    }

    public void setTipoPistaByIdTipoPista(TipoPistaEntity tipoPistaByIdTipoPista) {
        this.tipoPistaByIdTipoPista = tipoPistaByIdTipoPista;
    }

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id",insertable = false,updatable = false)
    public PreguntaEntity getPreguntaByIdPregunta() {
        return preguntaByIdPregunta;
    }

    public void setPreguntaByIdPregunta(PreguntaEntity preguntaByIdPregunta) {
        this.preguntaByIdPregunta = preguntaByIdPregunta;
    }
}
