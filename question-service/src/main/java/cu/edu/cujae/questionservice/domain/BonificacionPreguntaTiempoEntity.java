package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bonificacion_pregunta_tiempo", schema = "public", catalog = "tyke-questions")
public class BonificacionPreguntaTiempoEntity {
    private long id;
    private Long idPregunta;
    private Long tiempoMenor;
    private Integer bonificacion;
    private PreguntaEntity preguntaByIdPregunta;

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
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
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
        return id == that.id &&
                Objects.equals(idPregunta, that.idPregunta) &&
                Objects.equals(tiempoMenor, that.tiempoMenor) &&
                Objects.equals(bonificacion, that.bonificacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idPregunta, tiempoMenor, bonificacion);
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
