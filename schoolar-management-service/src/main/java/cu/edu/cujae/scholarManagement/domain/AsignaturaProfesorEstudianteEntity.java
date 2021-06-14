package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "asignatura_profesor_estudiante", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AsignaturaProfesorEstudianteEntityPK.class)

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AsignaturaProfesorEstudianteEntity implements Serializable {
    private Integer idAsignatura;
    private Integer idProfesor;
    private Integer idEstudiante;
    private AsignaturaEntity asignaturaByIdAsignatura;
    private ProfesorEntity profesorByIdProfesor;
    private EstudianteEntity estudianteByIdEstudiante;


    @Id
    @Column(name = "id_asignatura")
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Id
    @Column(name = "id_profesor")
    public Integer getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Integer idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Id
    @Column(name = "id_estudiante")
    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaProfesorEstudianteEntity that = (AsignaturaProfesorEstudianteEntity) o;
        return Objects.equals(idAsignatura, that.idAsignatura) &&
                Objects.equals(idProfesor, that.idProfesor) &&
                Objects.equals(idEstudiante, that.idEstudiante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idProfesor, idEstudiante);
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public ProfesorEntity getProfesorByIdProfesor() {
        return profesorByIdProfesor;
    }

    public void setProfesorByIdProfesor(ProfesorEntity profesorByIdProfesor) {
        this.profesorByIdProfesor = profesorByIdProfesor;
    }

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public EstudianteEntity getEstudianteByIdEstudiante() {
        return estudianteByIdEstudiante;
    }

    public void setEstudianteByIdEstudiante(EstudianteEntity estudianteByIdEstudiante) {
        this.estudianteByIdEstudiante = estudianteByIdEstudiante;
    }
}
