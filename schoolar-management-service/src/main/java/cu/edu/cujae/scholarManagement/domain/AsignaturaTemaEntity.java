package cu.edu.cujae.scholarManagement.domain;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "asignatura_tema", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AsignaturaTemaEntityPK.class)
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class AsignaturaTemaEntity implements Serializable {
    private Integer idAsignatura;
    private Integer idTema;
    private AsignaturaEntity asignaturaByIdAsignatura;
    private TemaEntity temaByIdTema;



    @Id
    @Column(name = "id_asignatura")
    public Integer getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(Integer idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Id
    @Column(name = "id_tema")
    public Integer getIdTema() {
        return idTema;
    }

    public void setIdTema(Integer idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaTemaEntity that = (AsignaturaTemaEntity) o;
        return Objects.equals(idAsignatura, that.idAsignatura) &&
                Objects.equals(idTema, that.idTema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idTema);
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }

    @ManyToOne
    @JoinColumn(name = "id_tema", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public TemaEntity getTemaByIdTema() {
        return temaByIdTema;
    }

    public void setTemaByIdTema(TemaEntity temaByIdTema) {
        this.temaByIdTema = temaByIdTema;
    }
}
