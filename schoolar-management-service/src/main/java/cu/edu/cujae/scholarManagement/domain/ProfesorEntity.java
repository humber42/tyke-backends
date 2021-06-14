package cu.edu.cujae.scholarManagement.domain;

import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@EqualsAndHashCode
@Entity
@Table(name = "profesor", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class ProfesorEntity implements Serializable {
    private Integer id;
    private String gradoCientifico;
    private String gradoDocente;
    private String telefono;
    private int id_usuario;
    private Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById;
    private FacultadEntity facultadByIdFacultad;






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
    @Column(name="id_usuario")
    public int getId_usuario(){return id_usuario;}

    public void setId_usuario(int id_usuario){
        this.id_usuario=id_usuario;
    }



    @OneToMany(mappedBy = "profesorByIdProfesor")
    public Collection<AsignaturaProfesorEstudianteEntity> getAsignaturaProfesorEstudiantesById() {
        return asignaturaProfesorEstudiantesById;
    }

    public void setAsignaturaProfesorEstudiantesById(Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById) {
        this.asignaturaProfesorEstudiantesById = asignaturaProfesorEstudiantesById;
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id", nullable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }

}
