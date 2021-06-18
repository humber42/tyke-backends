package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tema", schema = "public", catalog = "tyke-schoolar-management")
public class TemaEntity {
    private int id;
    private String nombre;
    private String description;
    private Collection<AsignaturaTemaEntity> asignaturaTemasById;

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
        TemaEntity entity = (TemaEntity) o;
        return id == entity.id &&
                Objects.equals(nombre, entity.nombre) &&
                Objects.equals(description, entity.description);
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
