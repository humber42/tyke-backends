package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "rol_profesional", schema = "public", catalog = "tyke-strategy")
public class RolProfesionalEntity {
    private long idRolProfesional;
    private Long idCarrera;
    private Long idTema;
    private String nombre;


    @Id
    @Column(name = "id_rol_profesional")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdRolProfesional() {
        return idRolProfesional;
    }

    public void setIdRolProfesional(long idRolProfesional) {
        this.idRolProfesional = idRolProfesional;
    }

    @Basic
    @Column(name = "id_carrera")
    public Long getIdCarrera() {
        return idCarrera;
    }

    public void setIdCarrera(Long idCarrera) {
        this.idCarrera = idCarrera;
    }

    @Basic
    @Column(name = "id_tema")
    public Long getIdTema() {
        return idTema;
    }

    public void setIdTema(Long idTema) {
        this.idTema = idTema;
    }

    @Basic
    @Column(name = "nombre")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolProfesionalEntity that = (RolProfesionalEntity) o;
        return idRolProfesional == that.idRolProfesional &&
                Objects.equals(idCarrera, that.idCarrera) &&
                Objects.equals(idTema, that.idTema) &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRolProfesional, idCarrera, idTema, nombre);
    }

}
