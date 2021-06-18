package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "asignatura", schema = "public", catalog = "tyke-schoolar-management")
public class AsignaturaEntity {
    private int id;
    private String nombre;
    private boolean activo;
    private Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById;
    private Collection<AsignaturaTemaEntity> asignaturaTemasById;
    private Collection<SemestreAsignaturaEntity> semestreAsignaturasById;
    private Collection<SignatureCareerEntity> signatureCareersById;

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
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "activo")
    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaEntity that = (AsignaturaEntity) o;
        return id == that.id &&
                activo == that.activo &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, activo);
    }

    @OneToMany(mappedBy = "asignaturaByIdAsignatura")
    public Collection<AsignaturaProfesorGrupoEntity> getAsignaturaProfesorGruposById() {
        return asignaturaProfesorGruposById;
    }

    public void setAsignaturaProfesorGruposById(Collection<AsignaturaProfesorGrupoEntity> asignaturaProfesorGruposById) {
        this.asignaturaProfesorGruposById = asignaturaProfesorGruposById;
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
    public Collection<SignatureCareerEntity> getSignatureCareersById() {
        return signatureCareersById;
    }

    public void setSignatureCareersById(Collection<SignatureCareerEntity> signatureCareersById) {
        this.signatureCareersById = signatureCareersById;
    }
}
