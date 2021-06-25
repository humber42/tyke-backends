package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "pregunta_respuesta", schema = "public", catalog = "tyke-questions")
public class PreguntaRespuestaEntity {
    private long id;
    private long idPregunta;
    private long idRespuesta;
    private Boolean correcta;
    private Long preguntaPadre;
    private Integer orden;
    private PreguntaEntity preguntaByIdPregunta;
    private RespuestaEntity respuestaByIdRespuesta;
    private PreguntaEntity preguntaByPreguntaPadre;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_pregunta")
    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "id_respuesta")
    public long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Basic
    @Column(name = "correcta")
    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    @Basic
    @Column(name = "pregunta_padre")
    public Long getPreguntaPadre() {
        return preguntaPadre;
    }

    public void setPreguntaPadre(Long preguntaPadre) {
        this.preguntaPadre = preguntaPadre;
    }

    @Basic
    @Column(name = "orden")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PreguntaRespuestaEntity that = (PreguntaRespuestaEntity) o;
        return id == that.id &&
                idPregunta == that.idPregunta &&
                idRespuesta == that.idRespuesta &&
                Objects.equals(correcta, that.correcta) &&
                Objects.equals(preguntaPadre, that.preguntaPadre) &&
                Objects.equals(orden, that.orden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPregunta, idRespuesta, correcta, preguntaPadre, orden);
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
