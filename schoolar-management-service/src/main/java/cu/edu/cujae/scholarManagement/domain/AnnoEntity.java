package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "anno", schema = "public", catalog = "tyke-schoolar-management")
public class AnnoEntity {
    private int id;
    private String anno;
    private Collection<AnnoGrupoEntity> annoGruposById;
    private Collection<AnnoSemestreEntity> annoSemestresById;
    private Collection<CursoAnnoEntity> cursoAnnosById;
    private Collection<EstudianteGrupoEntity> estudianteGruposById;

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
    @Column(name = "anno")
    public String getAnno() {
        return anno;
    }

    public void setAnno(String anno) {
        this.anno = anno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnnoEntity that = (AnnoEntity) o;
        return id == that.id &&
                Objects.equals(anno, that.anno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, anno);
    }

    @OneToMany(mappedBy = "annoByIdAnno")
    public Collection<AnnoGrupoEntity> getAnnoGruposById() {
        return annoGruposById;
    }

    public void setAnnoGruposById(Collection<AnnoGrupoEntity> annoGruposById) {
        this.annoGruposById = annoGruposById;
    }

    @OneToMany(mappedBy = "annoByIdAnno")
    public Collection<AnnoSemestreEntity> getAnnoSemestresById() {
        return annoSemestresById;
    }

    public void setAnnoSemestresById(Collection<AnnoSemestreEntity> annoSemestresById) {
        this.annoSemestresById = annoSemestresById;
    }

    @OneToMany(mappedBy = "annoByIdAnno")
    public Collection<CursoAnnoEntity> getCursoAnnosById() {
        return cursoAnnosById;
    }

    public void setCursoAnnosById(Collection<CursoAnnoEntity> cursoAnnosById) {
        this.cursoAnnosById = cursoAnnosById;
    }

    @OneToMany(mappedBy = "annoByIdAnno")
    public Collection<EstudianteGrupoEntity> getEstudianteGruposById() {
        return estudianteGruposById;
    }

    public void setEstudianteGruposById(Collection<EstudianteGrupoEntity> estudianteGruposById) {
        this.estudianteGruposById = estudianteGruposById;
    }
}
