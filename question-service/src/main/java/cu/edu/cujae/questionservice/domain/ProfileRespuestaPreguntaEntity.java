package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "profile_respuesta_pregunta", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class ProfileRespuestaPreguntaEntity implements Serializable {

    private long id;
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

        if (id != that.id) return false;
        if (tiempoSegundos != null ? !tiempoSegundos.equals(that.tiempoSegundos) : that.tiempoSegundos != null)
            return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tiempoSegundos != null ? tiempoSegundos.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "id_respuesta", referencedColumnName = "id")
    public RespuestaEntity getRespuestaByIdRespuesta() {
        return respuestaByIdRespuesta;
    }

    public void setRespuestaByIdRespuesta(RespuestaEntity respuestaByIdRespuesta) {
        this.respuestaByIdRespuesta = respuestaByIdRespuesta;
    }

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    public PreguntaEntity getPreguntaByIdPregunta() {
        return preguntaByIdPregunta;
    }

    public void setPreguntaByIdPregunta(PreguntaEntity preguntaByIdPregunta) {
        this.preguntaByIdPregunta = preguntaByIdPregunta;
    }
}
