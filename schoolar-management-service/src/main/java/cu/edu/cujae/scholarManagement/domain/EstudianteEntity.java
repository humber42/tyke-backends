package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estudiante", schema = "public", catalog = "tyke-schoolar-management")
public class EstudianteEntity {
    private int id;
    private Integer idUsuario;
    private Integer idFacultad;
    private FacultadEntity facultadByIdFacultad;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_usuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Basic
    @Column(name = "id_facultad")
    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteEntity that = (EstudianteEntity) o;
        return id == that.id &&
                Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idFacultad, that.idFacultad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idUsuario, idFacultad);
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id",updatable = false,insertable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }

    @OneToMany(mappedBy = "estudianteByIdEstudiante")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }
}
