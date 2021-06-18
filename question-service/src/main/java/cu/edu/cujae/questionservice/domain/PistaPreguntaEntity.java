package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pista_pregunta", schema = "public", catalog = "tyke-questions")
@IdClass(PistaPreguntaEntityPK.class)
public class PistaPreguntaEntity {

    private PreguntaEntity preguntaByIdPregunta;
    private PistaEntity pistaByIdPista;
    private long idPregunta;
    private long idPista;

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public PreguntaEntity getPreguntaByIdPregunta() {
        return preguntaByIdPregunta;
    }

    public void setPreguntaByIdPregunta(PreguntaEntity preguntaByIdPregunta) {
        this.preguntaByIdPregunta = preguntaByIdPregunta;
    }

    @ManyToOne
    @JoinColumn(name = "id_pista", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public PistaEntity getPistaByIdPista() {
        return pistaByIdPista;
    }

    public void setPistaByIdPista(PistaEntity pistaByIdPista) {
        this.pistaByIdPista = pistaByIdPista;
    }

    @Id
    @Column(name = "id_pregunta")
    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Id
    @Column(name = "id_pista")
    public long getIdPista() {
        return idPista;
    }

    public void setIdPista(long idPista) {
        this.idPista = idPista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PistaPreguntaEntity that = (PistaPreguntaEntity) o;

        if (idPregunta != that.idPregunta) return false;
        if (idPista != that.idPista) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPregunta ^ (idPregunta >>> 32));
        result = 31 * result + (int) (idPista ^ (idPista >>> 32));
        return result;
    }
}
