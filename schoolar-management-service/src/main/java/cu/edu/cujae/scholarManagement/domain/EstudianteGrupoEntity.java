package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "estudiante_grupo", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(EstudianteGrupoEntityPK.class)
public class EstudianteGrupoEntity {
    private int idEstudiante;
    private int idGrupo;
    private int idCurso;
    private int idAnno;
    private EstudianteEntity estudianteByIdEstudiante;
    private GrupoEntity grupoByIdGrupo;
    private CursoEntity cursoByIdCurso;
    private AnnoEntity annoByIdAnno;

    @Id
    @Column(name = "id_estudiante")
    public int getIdEstudiante() {
        return idEstudiante;
    }

    public void setIdEstudiante(int idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    @Id
    @Column(name = "id_grupo")
    public int getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
    }

    @Id
    @Column(name = "id_curso")
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Id
    @Column(name = "id_anno")
    public int getIdAnno() {
        return idAnno;
    }

    public void setIdAnno(int idAnno) {
        this.idAnno = idAnno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstudianteGrupoEntity that = (EstudianteGrupoEntity) o;
        return idEstudiante == that.idEstudiante &&
                idGrupo == that.idGrupo &&
                idCurso == that.idCurso &&
                idAnno == that.idAnno;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstudiante, idGrupo, idCurso, idAnno);
    }

    @ManyToOne
    @JoinColumn(name = "id_estudiante", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public EstudianteEntity getEstudianteByIdEstudiante() {
        return estudianteByIdEstudiante;
    }

    public void setEstudianteByIdEstudiante(EstudianteEntity estudianteByIdEstudiante) {
        this.estudianteByIdEstudiante = estudianteByIdEstudiante;
    }

    @ManyToOne
    @JoinColumn(name = "id_grupo", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public GrupoEntity getGrupoByIdGrupo() {
        return grupoByIdGrupo;
    }

    public void setGrupoByIdGrupo(GrupoEntity grupoByIdGrupo) {
        this.grupoByIdGrupo = grupoByIdGrupo;
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }

    @ManyToOne
    @JoinColumn(name = "id_anno", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AnnoEntity getAnnoByIdAnno() {
        return annoByIdAnno;
    }

    public void setAnnoByIdAnno(AnnoEntity annoByIdAnno) {
        this.annoByIdAnno = annoByIdAnno;
    }
}
