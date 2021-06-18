package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pregunta", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class PreguntaEntity implements Serializable {

    private long id;
    private String tituloPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;
    private Collection<BonificacionPreguntaTiempoEntity> bonificacionPreguntaTiemposById;
    private Collection<FeedbackEntity> feedbacksById;
    private Collection<PistaPreguntaEntity> pistaPreguntasById;
    private TipoPreguntaEntity tipoPreguntaByIdTipoPregunta;
    private Collection<PreguntaRespuestaEntity> preguntaRespuestasById;
    private Collection<PreguntaRespuestaEntity> preguntaRespuestasById_0;
    private Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById;

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
    @Column(name = "titulo_pregunta")
    public String getTituloPregunta() {
        return tituloPregunta;
    }

    public void setTituloPregunta(String tituloPregunta) {
        this.tituloPregunta = tituloPregunta;
    }

    @Basic
    @Column(name = "tiempo_en_segundos")
    public Integer getTiempoEnSegundos() {
        return tiempoEnSegundos;
    }

    public void setTiempoEnSegundos(Integer tiempoEnSegundos) {
        this.tiempoEnSegundos = tiempoEnSegundos;
    }

    @Basic
    @Column(name = "cant_puntos_completar_correctamente")
    public Integer getCantPuntosCompletarCorrectamente() {
        return cantPuntosCompletarCorrectamente;
    }

    public void setCantPuntosCompletarCorrectamente(Integer cantPuntosCompletarCorrectamente) {
        this.cantPuntosCompletarCorrectamente = cantPuntosCompletarCorrectamente;
    }

    @Basic
    @Column(name = "asignatura")
    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PreguntaEntity that = (PreguntaEntity) o;

        if (id != that.id) return false;
        if (tituloPregunta != null ? !tituloPregunta.equals(that.tituloPregunta) : that.tituloPregunta != null)
            return false;
        if (tiempoEnSegundos != null ? !tiempoEnSegundos.equals(that.tiempoEnSegundos) : that.tiempoEnSegundos != null)
            return false;
        if (cantPuntosCompletarCorrectamente != null ? !cantPuntosCompletarCorrectamente.equals(that.cantPuntosCompletarCorrectamente) : that.cantPuntosCompletarCorrectamente != null)
            return false;
        if (asignatura != null ? !asignatura.equals(that.asignatura) : that.asignatura != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tituloPregunta != null ? tituloPregunta.hashCode() : 0);
        result = 31 * result + (tiempoEnSegundos != null ? tiempoEnSegundos.hashCode() : 0);
        result = 31 * result + (cantPuntosCompletarCorrectamente != null ? cantPuntosCompletarCorrectamente.hashCode() : 0);
        result = 31 * result + (asignatura != null ? asignatura.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "preguntaByIdPregunta")
    public Collection<BonificacionPreguntaTiempoEntity> getBonificacionPreguntaTiemposById() {
        return bonificacionPreguntaTiemposById;
    }

    public void setBonificacionPreguntaTiemposById(Collection<BonificacionPreguntaTiempoEntity> bonificacionPreguntaTiemposById) {
        this.bonificacionPreguntaTiemposById = bonificacionPreguntaTiemposById;
    }

    @OneToMany(mappedBy = "preguntaByIdPregunta")
    public Collection<FeedbackEntity> getFeedbacksById() {
        return feedbacksById;
    }

    public void setFeedbacksById(Collection<FeedbackEntity> feedbacksById) {
        this.feedbacksById = feedbacksById;
    }

    @OneToMany(mappedBy = "preguntaByIdPregunta")
    public Collection<PistaPreguntaEntity> getPistaPreguntasById() {
        return pistaPreguntasById;
    }

    public void setPistaPreguntasById(Collection<PistaPreguntaEntity> pistaPreguntasById) {
        this.pistaPreguntasById = pistaPreguntasById;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_pregunta", referencedColumnName = "id")
    public TipoPreguntaEntity getTipoPreguntaByIdTipoPregunta() {
        return tipoPreguntaByIdTipoPregunta;
    }

    public void setTipoPreguntaByIdTipoPregunta(TipoPreguntaEntity tipoPreguntaByIdTipoPregunta) {
        this.tipoPreguntaByIdTipoPregunta = tipoPreguntaByIdTipoPregunta;
    }

    @OneToMany(mappedBy = "preguntaByIdPregunta")
    public Collection<PreguntaRespuestaEntity> getPreguntaRespuestasById() {
        return preguntaRespuestasById;
    }

    public void setPreguntaRespuestasById(Collection<PreguntaRespuestaEntity> preguntaRespuestasById) {
        this.preguntaRespuestasById = preguntaRespuestasById;
    }

    @OneToMany(mappedBy = "preguntaByPreguntaPadre")
    public Collection<PreguntaRespuestaEntity> getPreguntaRespuestasById_0() {
        return preguntaRespuestasById_0;
    }

    public void setPreguntaRespuestasById_0(Collection<PreguntaRespuestaEntity> preguntaRespuestasById_0) {
        this.preguntaRespuestasById_0 = preguntaRespuestasById_0;
    }

    @OneToMany(mappedBy = "preguntaByIdPregunta")
    public Collection<ProfileRespuestaPreguntaEntity> getProfileRespuestaPreguntasById() {
        return profileRespuestaPreguntasById;
    }

    public void setProfileRespuestaPreguntasById(Collection<ProfileRespuestaPreguntaEntity> profileRespuestaPreguntasById) {
        this.profileRespuestaPreguntasById = profileRespuestaPreguntasById;
    }
}
