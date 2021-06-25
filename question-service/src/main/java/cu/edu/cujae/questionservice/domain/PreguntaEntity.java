package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "pregunta", schema = "public", catalog = "tyke-questions")
public class PreguntaEntity {
    private long id;
    private String tituloPregunta;
    private Long idTipoPregunta;
    private Integer tiempoEnSegundos;
    private Integer cantPuntosCompletarCorrectamente;
    private String asignatura;

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
    @Column(name = "id_tipo_pregunta")
    public Long getIdTipoPregunta() {
        return idTipoPregunta;
    }

    public void setIdTipoPregunta(Long idTipoPregunta) {
        this.idTipoPregunta = idTipoPregunta;
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
        return id == that.id &&
                Objects.equals(tituloPregunta, that.tituloPregunta) &&
                Objects.equals(idTipoPregunta, that.idTipoPregunta) &&
                Objects.equals(tiempoEnSegundos, that.tiempoEnSegundos) &&
                Objects.equals(cantPuntosCompletarCorrectamente, that.cantPuntosCompletarCorrectamente) &&
                Objects.equals(asignatura, that.asignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tituloPregunta, idTipoPregunta, tiempoEnSegundos, cantPuntosCompletarCorrectamente, asignatura);
    }



}
