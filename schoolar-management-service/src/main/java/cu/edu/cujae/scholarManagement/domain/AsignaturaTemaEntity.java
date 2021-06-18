package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "asignatura_tema", schema = "public", catalog = "tyke-schoolar-management")
@IdClass(AsignaturaTemaEntityPK.class)
public class AsignaturaTemaEntity {
    private int idAsignatura;
    private int idTema;
    private AsignaturaEntity asignaturaByIdAsignatura;
    private TemaEntity temaByIdTema;

    @Id
    @Column(name = "id_asignatura")
    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    @Id
    @Column(name = "id_tema")
    public int getIdTema() {
        return idTema;
    }

    public void setIdTema(int idTema) {
        this.idTema = idTema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AsignaturaTemaEntity that = (AsignaturaTemaEntity) o;
        return idAsignatura == that.idAsignatura &&
                idTema == that.idTema;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idAsignatura, idTema);
    }

    @ManyToOne
    @JoinColumn(name = "id_asignatura", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public AsignaturaEntity getAsignaturaByIdAsignatura() {
        return asignaturaByIdAsignatura;
    }

    public void setAsignaturaByIdAsignatura(AsignaturaEntity asignaturaByIdAsignatura) {
        this.asignaturaByIdAsignatura = asignaturaByIdAsignatura;
    }

    @ManyToOne
    @JoinColumn(name = "id_tema", referencedColumnName = "id", nullable = false,updatable = false,insertable = false)
    public TemaEntity getTemaByIdTema() {
        return temaByIdTema;
    }

    public void setTemaByIdTema(TemaEntity temaByIdTema) {
        this.temaByIdTema = temaByIdTema;
    }
}
