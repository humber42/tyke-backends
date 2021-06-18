package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "asignatura_profesor_grupo", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AsignaturaProfesorGrupoEntityPK.class)
public class AsignaturaProfesorGrupoEntity {
    private int idAsignatura;
    private int idProfesor;
    private int idGrupo;
    private AsignaturaEntity asignaturaByIdAsignatura;
    private ProfesorEntity profesorByIdProfesor;
    private GrupoEntity grupoByIdGrupo;

    @Id
    @Column(name = "id_asignatura")
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Id
    @Column(name = "id_profesor")
    public int getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(int idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Id
    @Column(name = "id_grupo")
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaProfesorGrupoEntity that = (AsignaturaProfesorGrupoEntity) o;
        return idAsignatura == that.idAsignatura &&
                idProfesor == that.idProfesor &&
                idGrupo == that.idGrupo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idProfesor, idGrupo);
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }

    @ManyToOne
    @JoinColumn(name = "id_profesor", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public ProfesorEntity getProfesorByIdProfesor() {
        return profesorByIdProfesor;
    }

    public void setProfesorByIdProfesor(ProfesorEntity profesorByIdProfesor) {
        this.profesorByIdProfesor = profesorByIdProfesor;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public GrupoEntity getGrupoByIdGrupo() {
        return grupoByIdGrupo;
    }

    public void setGrupoByIdGrupo(GrupoEntity grupoByIdGrupo) {
        this.grupoByIdGrupo = grupoByIdGrupo;
    }
}
