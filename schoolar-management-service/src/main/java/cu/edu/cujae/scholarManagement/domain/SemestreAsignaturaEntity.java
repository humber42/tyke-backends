package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "semestre_asignatura", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(SemestreAsignaturaEntityPK.class)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SemestreAsignaturaEntity implements Serializable {
    private Integer idSemestre;
    private Integer idAsignatura;
    private SemestreEntity semestreByIdSemestre;
    private AsignaturaEntity asignaturaByIdAsignatura;


    @Id
    @Column(name = "id_semestre")
    public Integer getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(Integer idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Id
    @Column(name = "id_asignatura")
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreAsignaturaEntity that = (SemestreAsignaturaEntity) o;
        return Objects.equals(idSemestre, that.idSemestre) &&
                Objects.equals(idAsignatura, that.idAsignatura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemestre, idAsignatura);
    }

    @ManyToOne
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public SemestreEntity getSemestreByIdSemestre() {
        return semestreByIdSemestre;
    }

    public void setSemestreByIdSemestre(SemestreEntity semestreByIdSemestre) {
        this.semestreByIdSemestre = semestreByIdSemestre;
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }
}
