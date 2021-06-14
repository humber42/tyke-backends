package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tema", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class TemaEntity implements Serializable {
    private Integer id;
    private String nombre;
    private String description;
    private Collection<AsignaturaTemaEntity> asignaturaTemasById;

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

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemaEntity that = (TemaEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, description);
    }

    @OneToMany(mappedBy = "temaByIdTema")
    public Collection<AsignaturaTemaEntity> getAsignaturaTemasById() {
        return asignaturaTemasById;
    }

    public void setAsignaturaTemasById(Collection<AsignaturaTemaEntity> asignaturaTemasById) {
        this.asignaturaTemasById = asignaturaTemasById;
    }
}
