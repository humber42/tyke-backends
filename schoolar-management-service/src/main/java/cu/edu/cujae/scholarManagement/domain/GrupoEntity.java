package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "grupo", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GrupoEntity implements Serializable {
    private Long id;
    private String grupo;
    private Collection<AnnoGrupoEntity> annoGruposById;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GrupoEntity that = (GrupoEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(grupo, that.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, grupo);
    }

    @OneToMany(mappedBy = "grupoByIdGrupo")
    public Collection<AnnoGrupoEntity> getAnnoGruposById() {
        return annoGruposById;
    }

    public void setAnnoGruposById(Collection<AnnoGrupoEntity> annoGruposById) {
        this.annoGruposById = annoGruposById;
    }

    @OneToMany(mappedBy = "grupoByIdGrupo")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }
}
