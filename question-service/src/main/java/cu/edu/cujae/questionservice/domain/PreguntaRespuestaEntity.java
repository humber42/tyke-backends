package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "pregunta_respuesta", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PreguntaRespuestaEntity implements Serializable {

    private long id;
    private Boolean correcta;
    private PreguntaEntity preguntaByIdPregunta;
    private RespuestaEntity respuestaByIdRespuesta;
    private PreguntaEntity preguntaByPreguntaPadre;

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
    @Column(name = "correcta")
    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreguntaRespuestaEntity that = (PreguntaRespuestaEntity) o;

        if (id != that.id) return false;
        if (correcta != null ? !correcta.equals(that.correcta) : that.correcta != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (correcta != null ? correcta.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id", nullable = false)
    public RespuestaEntity getRespuestaByIdRespuesta() {
        return respuestaByIdRespuesta;
    }

    public void setRespuestaByIdRespuesta(RespuestaEntity respuestaByIdRespuesta) {
        this.respuestaByIdRespuesta = respuestaByIdRespuesta;
    }

    @ManyToOne
    @JoinColumn(name = "pregunta_padre", referencedColumnName = "id")
    public PreguntaEntity getPreguntaByPreguntaPadre() {
        return preguntaByPreguntaPadre;
    }

    public void setPreguntaByPreguntaPadre(PreguntaEntity preguntaByPreguntaPadre) {
        this.preguntaByPreguntaPadre = preguntaByPreguntaPadre;
    }
}
