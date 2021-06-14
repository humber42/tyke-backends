package cu.edu.cujae.scholarManagement.domain;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@EqualsAndHashCode
@Entity
@Table(name = "estudiante", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EstudianteEntity implements Serializable {
    private Integer id;
    private int id_usuario;
    private int id_facultad;
    private FacultadEntity facultadByIdFacultad;
    private Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;


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
    @Column(name="id_usuario")
    public int getId_usuario(){return id_usuario;}

    public void setId_usuario(int id_usuario){
        this.id_usuario=id_usuario;
    }

    @Basic
    @Column(name="id_facultad")
    public int getId_facultad(){
        return id_facultad;
    }
    public void setId_facultad(int id_facultad){
        this.id_facultad=id_facultad;
    }

    @OneToMany(mappedBy = "estudianteByIdEstudiante")
    public Collection<AsignaturaProfesorEstudianteEntity> getAsignaturaProfesorEstudiantesById() {
        return asignaturaProfesorEstudiantesById;
    }

    public void setAsignaturaProfesorEstudiantesById(Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById) {
        this.asignaturaProfesorEstudiantesById = asignaturaProfesorEstudiantesById;
    }

    @OneToMany(mappedBy = "estudianteByIdEstudiante")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id",nullable = false,updatable = false,insertable = false)
    public FacultadEntity getFacultadByIdFacultad(){
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad){
        this.facultadByIdFacultad=facultadByIdFacultad;
    }
}
