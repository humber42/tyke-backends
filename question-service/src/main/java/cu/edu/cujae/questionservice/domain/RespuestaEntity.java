package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "respuesta", schema = "public", catalog = "tyke-questions")
public class RespuestaEntity {
    private long id;
    private String texto;
    private Integer puntuacion;
    private Collection<PreguntaRespuestaEntity> preguntaRespuestasById;
    private Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "texto")
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Basic
    @Column(name = "puntuacion")
    public Integer getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Integer puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RespuestaEntity that = (RespuestaEntity) o;
        return id == that.id &&
                Objects.equals(texto, that.texto) &&
                Objects.equals(puntuacion, that.puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texto, puntuacion);
    }

    @OneToMany(mappedBy = "respuestaByIdRespuesta")
    public Collection<PreguntaRespuestaEntity> getPreguntaRespuestasById() {
        return preguntaRespuestasById;
    }

    public void setPreguntaRespuestasById(Collection<PreguntaRespuestaEntity> preguntaRespuestasById) {
        this.preguntaRespuestasById = preguntaRespuestasById;
    }

    @OneToMany(mappedBy = "respuestaByIdRespuesta")
    public Collection<ProfileRespuestaPreguntaEntity> getProfileRespuestaPreguntasById() {
        return profileRespuestaPreguntasById;
    }

    public void setProfileRespuestaPreguntasById(Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById) {
        this.profileRespuestaPreguntasById = profileRespuestaPreguntasById;
    }
}
