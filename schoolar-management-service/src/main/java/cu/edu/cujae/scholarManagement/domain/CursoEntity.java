package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "curso", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CursoEntity implements Serializable {
    private Integer id;
    private String curso;
    private Boolean activo;
    private Collection<CursoAnnoEntity> cursoAnnosById;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;
    private Collection<FacultadCursoEntity> facultadCursosById;


    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "curso")
    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Basic
    @Column(name = "activo")
    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CursoEntity that = (CursoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(curso, that.curso) &&
                Objects.equals(activo, that.activo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, curso, activo);
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<CursoAnnoEntity> getCursoAnnosById() {
        return cursoAnnosById;
    }

    public void setCursoAnnosById(Collection<CursoAnnoEntity> cursoAnnosById) {
        this.cursoAnnosById = cursoAnnosById;
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }

    @OneToMany(mappedBy = "cursoByIdCurso")
    public Collection<FacultadCursoEntity> getFacultadCursosById() {
        return facultadCursosById;
    }

    public void setFacultadCursosById(Collection<FacultadCursoEntity> facultadCursosById) {
        this.facultadCursosById = facultadCursosById;
    }
}
