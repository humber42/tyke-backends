package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "profile_respuesta_pregunta", schema = "public", catalog = "tyke-questions")
public class ProfileRespuestaPreguntaEntity {
    private long id;
    private Long idRespuesta;
    private Long idPregunta;
    private Integer tiempoSegundos;
    private String username;
    private RespuestaEntity respuestaByIdRespuesta;
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
    @Column(name = "id_respuesta")
    public Long getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(Long idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    @Basic
    @Column(name = "id_pregunta")
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "tiempo_segundos")
    public Integer getTiempoSegundos() {
        return tiempoSegundos;
    }

    public void setTiempoSegundos(Integer tiempoSegundos) {
        this.tiempoSegundos = tiempoSegundos;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfileRespuestaPreguntaEntity that = (ProfileRespuestaPreguntaEntity) o;
        return id == that.id &&
                Objects.equals(idRespuesta, that.idRespuesta) &&
                Objects.equals(idPregunta, that.idPregunta) &&
                Objects.equals(tiempoSegundos, that.tiempoSegundos) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idRespuesta, idPregunta, tiempoSegundos, username);
    }

    @ManyToOne
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id",insertable = false,updatable = false)
    public RespuestaEntity getRespuestaByIdRespuesta() {
        return respuestaByIdRespuesta;
    }

    public void setRespuestaByIdRespuesta(RespuestaEntity respuestaByIdRespuesta) {
        this.respuestaByIdRespuesta = respuestaByIdRespuesta;
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
