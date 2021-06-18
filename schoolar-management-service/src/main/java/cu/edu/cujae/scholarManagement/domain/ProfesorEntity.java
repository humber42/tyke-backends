package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "profesor", schema = "public", catalog = "tyke-schoolar-management")
public class ProfesorEntity {
    private int id;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private int idFacultad;
    private Integer idUsuario;
    private Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById;
    private FacultadEntity facultadByIdFacultad;

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
    @Column(name = "grado_cientifico")
    public String getGradoCientifico() {
        return gradoCientifico;
    }

    public void setGradoCientifico(String gradoCientifico) {
        this.gradoCientifico = gradoCientifico;
    }

    @Basic
    @Column(name = "grado_docente")
    public String getGradoDocente() {
        return gradoDocente;
    }

    public void setGradoDocente(String gradoDocente) {
        this.gradoDocente = gradoDocente;
    }

    @Basic
    @Column(name = "telefono")
    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Basic
    @Column(name = "id_facultad")
    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Basic
    @Column(name = "id_usuario")
    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProfesorEntity that = (ProfesorEntity) o;
        return id == that.id &&
                idFacultad == that.idFacultad &&
                Objects.equals(gradoCientifico, that.gradoCientifico) &&
                Objects.equals(gradoDocente, that.gradoDocente) &&
                Objects.equals(telefono, that.telefono) &&
                Objects.equals(idUsuario, that.idUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, gradoCientifico, gradoDocente, telefono, idFacultad, idUsuario);
    }

    @OneToMany(mappedBy = "profesorByIdProfesor")
    public Collection<AsignaturaProfesorGrupoEntity> getAsignaturaProfesorGruposById() {
        return asignaturaProfesorGruposById;
    }

    public void setAsignaturaProfesorGruposById(Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById) {
        this.asignaturaProfesorGruposById = asignaturaProfesorGruposById;
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }
}
