package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "semestre_asignatura", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(SemestreAsignaturaEntityPK.class)
public class SemestreAsignaturaEntity {
    private int idSemestre;
    private int idAsignatura;
    private SemestreEntity semestreByIdSemestre;
    private AsignaturaEntity asignaturaByIdAsignatura;

    @Id
    @Column(name = "id_semestre")
    public int getIdSemestre() {
        return idSemestre;
    }

    public void setIdSemestre(int idSemestre) {
        this.idSemestre = idSemestre;
    }

    @Id
    @Column(name = "id_asignatura")
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreAsignaturaEntity that = (SemestreAsignaturaEntity) o;
        return idSemestre == that.idSemestre &&
                idAsignatura == that.idAsignatura;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idSemestre, idAsignatura);
    }

    @ManyToOne
    @JoinColumn(name = "id_semestre", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public SemestreEntity getSemestreByIdSemestre() {
        return semestreByIdSemestre;
    }

    public void setSemestreByIdSemestre(SemestreEntity semestreByIdSemestre) {
        this.semestreByIdSemestre = semestreByIdSemestre;
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }
}
