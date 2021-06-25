package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pista_pregunta", schema = "public", catalog = "tyke-questions")
public class PistaPreguntaEntity {
    private long idPregunta;
    private long idPista;
    private long id;
    private PreguntaEntity preguntaByIdPregunta;
    private PistaEntity pistaByIdPista;

    @Basic
    @Column(name = "id_pregunta")
    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "id_pista")
    public long getIdPista() {
        return idPista;
    }

    public void setIdPista(long idPista) {
        this.idPista = idPista;
    }

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PistaPreguntaEntity that = (PistaPreguntaEntity) o;
        return idPregunta == that.idPregunta &&
                idPista == that.idPista &&
                id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPregunta, idPista, id);
    }

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id", nullable = false)
    public PreguntaEntity getPreguntaByIdPregunta() {
        return preguntaByIdPregunta;
    }

    public void setPreguntaByIdPregunta(PreguntaEntity preguntaByIdPregunta) {
        this.preguntaByIdPregunta = preguntaByIdPregunta;
    }

    @ManyToOne
    @JoinColumn(name = "id_pista", referencedColumnName = "id", nullable = false)
    public PistaEntity getPistaByIdPista() {
        return pistaByIdPista;
    }

    public void setPistaByIdPista(PistaEntity pistaByIdPista) {
        this.pistaByIdPista = pistaByIdPista;
    }
}
