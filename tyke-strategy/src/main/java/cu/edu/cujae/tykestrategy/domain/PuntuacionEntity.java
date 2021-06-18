package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "puntuacion", schema = "public", catalog = "tyke-strategy")
public class PuntuacionEntity {
    private long idPuntuacion;
    private Long idEstudiante;
    private Long puntuacion;

    @Id
    @Column(name = "id_puntuacion")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdPuntuacion() {
        return idPuntuacion;
    }

    public void setIdPuntuacion(long idPuntuacion) {
        this.idPuntuacion = idPuntuacion;
    }

    @Basic
    @Column(name = "id_estudiante")
    public Long getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Long idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Basic
    @Column(name = "puntuacion")
    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PuntuacionEntity that = (PuntuacionEntity) o;
        return idPuntuacion == that.idPuntuacion &&
                Objects.equals(idEstudiante, that.idEstudiante) &&
                Objects.equals(puntuacion, that.puntuacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPuntuacion, idEstudiante, puntuacion);
    }
}
