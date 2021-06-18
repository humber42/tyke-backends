package cu.edu.cujae.questionservice.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bonificacion_pregunta_tiempo", schema = "public", catalog = "tyke-questions")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BonificacionPreguntaTiempoEntity implements Serializable {


    private long id;
    private Long tiempoMenor;
    private Integer bonificacion;
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
    @Column(name = "tiempo_menor")
    public Long getTiempoMenor() {
        return tiempoMenor;
    }

    public void setTiempoMenor(Long tiempoMenor) {
        this.tiempoMenor = tiempoMenor;
    }

    @Basic
    @Column(name = "bonificacion")
    public Integer getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Integer bonificacion) {
        this.bonificacion = bonificacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BonificacionPreguntaTiempoEntity that = (BonificacionPreguntaTiempoEntity) o;

        if (id != that.id) return false;
        if (tiempoMenor != null ? !tiempoMenor.equals(that.tiempoMenor) : that.tiempoMenor != null) return false;
        if (bonificacion != null ? !bonificacion.equals(that.bonificacion) : that.bonificacion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tiempoMenor != null ? tiempoMenor.hashCode() : 0);
        result = 31 * result + (bonificacion != null ? bonificacion.hashCode() : 0);
        return result;
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
