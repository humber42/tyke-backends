package cu.edu.cujae.scholarManagement.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "carrera", schema = "public", catalog = "tyke-schoolar-management")
public class CarreraEntity {
    private Integer id;
    private String nombre;
    private String siglas;
    private FacultadEntity facultadByIdFacultad;



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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarreraEntity that = (CarreraEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(siglas, that.siglas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, siglas);
    }

    @ManyToOne
    @JoinColumn(name = "id_facultad", referencedColumnName = "id")
    public FacultadEntity getFacultadByIdFacultad() {
        return facultadByIdFacultad;
    }

    public void setFacultadByIdFacultad(FacultadEntity facultadByIdFacultad) {
        this.facultadByIdFacultad = facultadByIdFacultad;
    }
}
