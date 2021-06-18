package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "carrera", schema = "public", catalog = "tyke-schoolar-management")
public class CarreraEntity {
    private int id;
    private String nombre;
    private String siglas;
    private Integer idFacultad;
    private FacultadEntity facultadByIdFacultad;
    private Collection<GrupoEntity> gruposById;
    private Collection<SignatureCareerEntity> signatureCareersById;

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
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "siglas")
    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    @Basic
    @Column(name = "id_facultad")
    public Integer getIdFacultad() {
        return idFacultad;
    }

    public void setIdFacultad(Integer idFacultad) {
        this.idFacultad = idFacultad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarreraEntity that = (CarreraEntity) o;
        return id == that.id &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(siglas, that.siglas) &&
                Objects.equals(idFacultad, that.idFacultad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, siglas, idFacultad);
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id",updatable = false,insertable = false)
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }

    @OneToMany(mappedBy = "carreraByIdCarrera")
    public Collection<GrupoEntity> getGruposById() {
        return gruposById;
    }

    public void setGruposById(Collection<GrupoEntity> gruposById) {
        this.gruposById = gruposById;
    }

    @OneToMany(mappedBy = "carreraByIdCareer")
    public Collection<SignatureCareerEntity> getSignatureCareersById() {
        return signatureCareersById;
    }

    public void setSignatureCareersById(Collection<SignatureCareerEntity> signatureCareersById) {
        this.signatureCareersById = signatureCareersById;
    }
}
