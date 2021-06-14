package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "signature_career", schema = "public", catalog = "tyke-schoolar-management")
public class SignatureCareerEntity {
    private long id;
    private Integer idCareer;
    private Integer idSignature;
    private CarreraEntity carreradByIdCarrera;
    private AsignaturaEntity asignaturaByIdSignature;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "id_career")
    public Integer getIdCareer() {
        return idCareer;
    }

    public void setIdCareer(Integer idCareer) {
        this.idCareer = idCareer;
    }

    @Basic
    @Column(name = "id_signature")
    public Integer getIdSignature() {
        return idSignature;
    }

    public void setIdSignature(Integer idSignature) {
        this.idSignature = idSignature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SignatureCareerEntity that = (SignatureCareerEntity) o;
        return id == that.id &&
                Objects.equals(idCareer, that.idCareer) &&
                Objects.equals(idSignature, that.idSignature);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idCareer, idSignature);
    }

    @ManyToOne
    @JoinColumn(name = "id_career", referencedColumnName = "id",insertable = false,updatable = false)
    public CarreraEntity getCarreraByIdCarrera() {
        return carreradByIdCarrera;
    }

    public void setCarreraByIdCarrera(CarreraEntity carreradByIdCarrera) {
        this.carreradByIdCarrera = carreradByIdCarrera;
    }

    @ManyToOne
    @JoinColumn(name = "id_signature", referencedColumnName = "id",insertable = false,updatable = false)
    public AsignaturaEntity getAsignaturaByIdSignature() {
        return asignaturaByIdSignature;
    }

    public void setAsignaturaByIdSignature(AsignaturaEntity asignaturaByIdSignature) {
        this.asignaturaByIdSignature = asignaturaByIdSignature;
    }
}
