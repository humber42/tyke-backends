package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "semestre", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SemestreEntity implements Serializable {
    private Integer id;
    private String semestre;
    private Integer activo;
    private Collection<AnnoSemestreEntity> annoSemestresById;
    private Collection<SemestreAsignaturaEntity> semestreAsignaturasById;

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
    @Column(name = "semestre")
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    @Basic
    @Column(name = "activo")
    public Integer getActivo() {
        return activo;
    }

    public void setActivo(Integer activo) {
        this.activo = activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SemestreEntity that = (SemestreEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(semestre, that.semestre) &&
                Objects.equals(activo, that.activo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, semestre, activo);
    }

    @OneToMany(mappedBy = "semestreByIdSemestre")
    public Collection<AnnoSemestreEntity> getAnnoSemestresById() {
        return annoSemestresById;
    }

    public void setAnnoSemestresById(Collection<AnnoSemestreEntity> annoSemestresById) {
        this.annoSemestresById = annoSemestresById;
    }

    @OneToMany(mappedBy = "semestreByIdSemestre")
    public Collection<SemestreAsignaturaEntity> getSemestreAsignaturasById() {
        return semestreAsignaturasById;
    }

    public void setSemestreAsignaturasById(Collection<SemestreAsignaturaEntity> semestreAsignaturasById) {
        this.semestreAsignaturasById = semestreAsignaturasById;
    }
}
