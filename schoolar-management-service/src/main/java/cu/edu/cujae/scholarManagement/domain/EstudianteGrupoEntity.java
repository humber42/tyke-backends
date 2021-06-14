package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "estudiante_grupo", schema = "public", catalog = "tyke-schoolar-management")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class EstudianteGrupoEntity implements Serializable {
    private Integer idEstudiante;
    private Integer idGrupo;
    private Integer idCurso;
    private Integer idAnno;
    private EstudianteEntity estudianteByIdEstudiante;
    private GrupoEntity grupoByIdGrupo;
    private CursoEntity cursoByIdCurso;
    private AnnoEntity annoByIdAnno;

    @Id
    @Column(name = "id_estudiante")
    public Integer getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(Integer idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Id
    @Column(name = "id_grupo")
    public Integer getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(Integer idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Id
    @Column(name = "id_curso")
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Id
    @Column(name = "id_anno")
    public Integer getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(Integer idAnno) {
        this.idAnno = idAnno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteGrupoEntity that = (EstudianteGrupoEntity) o;
        return Objects.equals(idEstudiante, that.idEstudiante) &&
                Objects.equals(idGrupo, that.idGrupo) &&
                Objects.equals(idCurso, that.idCurso) &&
                Objects.equals(idAnno, that.idAnno);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idGrupo, idCurso, idAnno);
    }

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id", nullable = false)
    public EstudianteEntity getEstudianteByIdEstudiante() {
        return estudianteByIdEstudiante;
    }

    public void setEstudianteByIdEstudiante(EstudianteEntity estudianteByIdEstudiante) {
        this.estudianteByIdEstudiante = estudianteByIdEstudiante;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", nullable = false)
    public GrupoEntity getGrupoByIdGrupo() {
        return grupoByIdGrupo;
    }

    public void setGrupoByIdGrupo(GrupoEntity grupoByIdGrupo) {
        this.grupoByIdGrupo = grupoByIdGrupo;
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }
}
