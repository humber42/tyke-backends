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
    private Boolean correcta;
    private Integer orden;
    private String textoEnlazar;
    private Long idPregunta;
    private Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById;
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

    @Basic
    @Column(name = "correcta")
    public Boolean getCorrecta() {
        return correcta;
    }

    public void setCorrecta(Boolean correcta) {
        this.correcta = correcta;
    }

    @Basic
    @Column(name = "orden")
    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    @Basic
    @Column(name = "texto_enlazar")
    public String getTextoEnlazar() {
        return textoEnlazar;
    }

    public void setTextoEnlazar(String textoEnlazar) {
        this.textoEnlazar = textoEnlazar;
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
        RespuestaEntity that = (RespuestaEntity) o;
        return id == that.id &&
                Objects.equals(texto, that.texto) &&
                Objects.equals(puntuacion, that.puntuacion) &&
                Objects.equals(correcta, that.correcta) &&
                Objects.equals(orden, that.orden) &&
                Objects.equals(textoEnlazar, that.textoEnlazar) &&
                Objects.equals(idPregunta, that.idPregunta);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, texto, puntuacion, correcta, orden, textoEnlazar, idPregunta);
    }

    @OneToMany(mappedBy = "respuestaByIdRespuesta")
    public Collection<ProfileRespuestaPreguntaEntity> getProfileRespuestaPreguntasById() {
        return profileRespuestaPreguntasById;
    }

    public void setProfileRespuestaPreguntasById(Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById) {
        this.profileRespuestaPreguntasById = profileRespuestaPreguntasById;
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
