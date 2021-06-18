package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "facultad_curso", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(FacultadCursoEntityPK.class)
public class FacultadCursoEntity {
    private int idFacultad;
    private int idCurso;
    private FacultadEntity facultadByIdFacultad;
    private CursoEntity cursoByIdCurso;

    @Id
    @Column(name = "id_facultad")
    public int getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(int idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Id
    @Column(name = "id_curso")
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadCursoEntity that = (FacultadCursoEntity) o;
        return idFacultad == that.idFacultad &&
                idCurso == that.idCurso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacultad, idCurso);
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }
}
