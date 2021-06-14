package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "facultad_curso", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(FacultadCursoEntityPK.class)

@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class FacultadCursoEntity implements Serializable {
    private Integer idFacultad;
    private Integer idCurso;
    private FacultadEntity facultadByIdFacultad;
    private CursoEntity cursoByIdCurso;


    @Id
    @Column(name = "id_facultad")
    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Id
    @Column(name = "id_curso")
    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultadCursoEntity that = (FacultadCursoEntity) o;
        return Objects.equals(idFacultad, that.idFacultad) &&
                Objects.equals(idCurso, that.idCurso);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idFacultad, idCurso);
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }

    @ManyToOne
    @JoinColumn(name = "id_curso", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public CursoEntity getCursoByIdCurso() {
        return cursoByIdCurso;
    }

    public void setCursoByIdCurso(CursoEntity cursoByIdCurso) {
        this.cursoByIdCurso = cursoByIdCurso;
    }
}
