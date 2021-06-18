package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "grupo", schema = "public", catalog = "tyke-schoolar-management")
public class GrupoEntity {
    private long id;
    private String grupo;
    private Integer idCarrera;
    private Collection<AnnoGrupoEntity> annoGruposById;
    private Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;
    private CarreraEntity carreraByIdCarrera;

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
    @Column(name = "grupo")
    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    @Basic
    @Column(name = "id_carrera")
    public Integer getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Integer idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEntity that = (GrupoEntity) o;
        return id == that.id &&
                Objects.equals(grupo, that.grupo) &&
                Objects.equals(idCarrera, that.idCarrera);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grupo, idCarrera);
    }

    @OneToMany(mappedBy = "grupoByIdGrupo")
    public Collection<AnnoGrupoEntity> getAnnoGruposById() {
        return annoGruposById;
    }

    public void setAnnoGruposById(Collection<AnnoGrupoEntity> annoGruposById) {
        this.annoGruposById = annoGruposById;
    }

    @OneToMany(mappedBy = "grupoByIdGrupo")
    public Collection<AsignaturaProfesorGrupoEntity> getAsignaturaProfesorGruposById() {
        return asignaturaProfesorGruposById;
    }

    public void setAsignaturaProfesorGruposById(Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById) {
        this.asignaturaProfesorGruposById = asignaturaProfesorGruposById;
    }

    @OneToMany(mappedBy = "grupoByIdGrupo")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }

    @ManyToOne
    @JoinColumn(name = "id_carrera", referencedColumnName = "id",updatable = false,insertable = false)
    public CarreraEntity getCarreraByIdCarrera() {
        return carreraByIdCarrera;
    }

    public void setCarreraByIdCarrera(CarreraEntity carreraByIdCarrera) {
        this.carreraByIdCarrera = carreraByIdCarrera;
    }
}
