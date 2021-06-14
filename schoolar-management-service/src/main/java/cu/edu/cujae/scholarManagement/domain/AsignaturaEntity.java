package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "asignatura", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AsignaturaEntity implements Serializable {
    private Integer id;
    private String nombre;
    private Boolean activo;
    private Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById;
    private Collection<AsignaturaTemaEntity> asignaturaTemasById;
    private Collection<SemestreAsignaturaEntity> semestreAsignaturasById;
    private Collection<SignatureCareerEntity> signatureCareerById;



    @Basic
    @Column(name = "activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

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
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaEntity that = (AsignaturaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(activo, that.activo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, activo);
    }

    @OneToMany(mappedBy = "asignaturaByIdAsignatura")
    public Collection<AsignaturaProfesorEstudianteEntity> getAsignaturaProfesorEstudiantesById() {
        return asignaturaProfesorEstudiantesById;
    }

    public void setAsignaturaProfesorEstudiantesById(Collection<AsignaturaProfesorEstudianteEntity> asignaturaProfesorEstudiantesById) {
        this.asignaturaProfesorEstudiantesById = asignaturaProfesorEstudiantesById;
    }

    @OneToMany(mappedBy = "asignaturaByIdAsignatura")
    public Collection<AsignaturaTemaEntity> getAsignaturaTemasById() {
        return asignaturaTemasById;
    }

    public void setAsignaturaTemasById(Collection<AsignaturaTemaEntity> asignaturaTemasById) {
        this.asignaturaTemasById = asignaturaTemasById;
    }

    @OneToMany(mappedBy = "asignaturaByIdAsignatura")
    public Collection<SemestreAsignaturaEntity> getSemestreAsignaturasById() {
        return semestreAsignaturasById;
    }

    public void setSemestreAsignaturasById(Collection<SemestreAsignaturaEntity> semestreAsignaturasById) {
        this.semestreAsignaturasById = semestreAsignaturasById;
    }

    @OneToMany(mappedBy = "asignaturaByIdSignature")
    public Collection<SignatureCareerEntity> getSignatureCareerById() {
        return signatureCareerById;
    }

    public void setSignatureCareerById(Collection<SignatureCareerEntity> signatureCareerById) {
        this.signatureCareerById = signatureCareerById;
    }
}
