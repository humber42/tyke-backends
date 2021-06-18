package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "facultad", schema = "public", catalog = "tyke-schoolar-management")
public class FacultadEntity {
    private int id;
    private String facultad;
    private String siglas;
    private Collection<CarreraEntity> carrerasById;
    private Collection<EstudianteEntity> estudiantesById;
    private Collection<FacultadCursoEntity> facultadCursosById;
    private Collection<ProfesorEntity> profesorsById;
    private String imagen;

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
    @Column(name = "facultad")
    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Basic
    @Column(name = "siglas")
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Basic
    @Column(name = "imagen")
    public String getImagen(){return imagen;}

    public void setImagen(String imagen){this.imagen = imagen;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadEntity that = (FacultadEntity) o;
        return id == that.id &&
                Objects.equals(facultad, that.facultad) &&
                Objects.equals(siglas, that.siglas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, facultad, siglas);
    }

    @OneToMany(mappedBy = "facultadByIdFacultad")
    public Collection<CarreraEntity> getCarrerasById() {
        return carrerasById;
    }

    public void setCarrerasById(Collection<CarreraEntity> carrerasById) {
        this.carrerasById = carrerasById;
    }

    @OneToMany(mappedBy = "facultadByIdFacultad")
    public Collection<EstudianteEntity> getEstudiantesById() {
        return estudiantesById;
    }

    public void setEstudiantesById(Collection<EstudianteEntity> estudiantesById) {
        this.estudiantesById = estudiantesById;
    }

    @OneToMany(mappedBy = "facultadByIdFacultad")
    public Collection<FacultadCursoEntity> getFacultadCursosById() {
        return facultadCursosById;
    }

    public void setFacultadCursosById(Collection<FacultadCursoEntity> facultadCursosById) {
        this.facultadCursosById = facultadCursosById;
    }

    @OneToMany(mappedBy = "facultadByIdFacultad")
    public Collection<ProfesorEntity> getProfesorsById() {
        return profesorsById;
    }

    public void setProfesorsById(Collection<ProfesorEntity> profesorsById) {
        this.profesorsById = profesorsById;
    }
}
