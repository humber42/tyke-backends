package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "insignia", schema = "public", catalog = "tyke-strategy")
public class InsigniaEntity {
    private long idInsignia;
    private String nombre;
    private Integer puntosAvance;
    private Integer puntosOtorgar;
    private RolProfesionalEntity rolProfesional;
    private Collection<JugadorInsigniaEntity> jugadores;

    @Id
    @Column(name = "id_insignia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdInsignia() {
        return idInsignia;
    }

    public void setIdInsignia(long idInsignia) {
        this.idInsignia = idInsignia;
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
    @Column(name = "puntos_avance")
    public Integer getPuntosAvance() {
        return puntosAvance;
    }

    public void setPuntosAvance(Integer puntosAvance) {
        this.puntosAvance = puntosAvance;
    }


    @Basic
    @Column(name = "puntos_otorgar")
    public Integer getPuntosOtorgar() {
        return puntosOtorgar;
    }

    public void setPuntosOtorgar(Integer puntosOtorgar) {
        this.puntosOtorgar = puntosOtorgar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InsigniaEntity that = (InsigniaEntity) o;
        return idInsignia == that.idInsignia &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(puntosAvance, that.puntosAvance) &&
                Objects.equals(puntosOtorgar, that.puntosOtorgar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInsignia, nombre, puntosAvance, puntosOtorgar);
    }

    @ManyToOne
    @JoinColumn(name = "id_rol", referencedColumnName = "id_rol_profesional")
    public RolProfesionalEntity getRolProfesional() {
        return rolProfesional;
    }

    public void setRolProfesional(RolProfesionalEntity rolProfesionalByIdRol) {
        this.rolProfesional = rolProfesionalByIdRol;
    }

    @OneToMany(mappedBy = "insignia")
    public Collection<JugadorInsigniaEntity> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Collection<JugadorInsigniaEntity> jugadorInsigniasByIdInsignia) {
        this.jugadores = jugadorInsigniasByIdInsignia;
    }
}
