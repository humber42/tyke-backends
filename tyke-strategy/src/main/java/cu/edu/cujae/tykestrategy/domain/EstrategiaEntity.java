package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "estrategia", schema = "public", catalog = "tyke-strategy")
public class EstrategiaEntity {
    private long idEstrategia;
    private Integer puntos;
    private String nombre;
    private Date fecha;
    private Long idProfesor;
    private Boolean habilitada;
    private Boolean evaluada;
    private Collection<EstrategiaGrupoEntity> grupos;
    private Collection<EstrategiaTemaEntity> temas;
    private Collection<JugadorDesafioEntity> desafios;
    private Collection<JugadorEstrategiaEntity> jugadores;
    private Collection<EstrategiaPreguntaEntity> estrategiaPreguntasByIdEstrategia;

    @Id
    @Column(name = "id_estrategia")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdEstrategia() {
        return idEstrategia;
    }

    public void setIdEstrategia(long idEstrategia) {
        this.idEstrategia = idEstrategia;
    }

    @Basic
    @Column(name = "puntos")
    public Integer getPuntos() {
        return puntos;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
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
    @Column(name = "fecha")
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "id_profesor")
    public Long getIdProfesor() {
        return idProfesor;
    }

    public void setIdProfesor(Long idProfesor) {
        this.idProfesor = idProfesor;
    }

    @Basic
    @Column(name = "habilitada")
    public Boolean getHabilitada() {
        return habilitada;
    }

    public void setHabilitada(Boolean habilitada) {
        this.habilitada = habilitada;
    }

    @Basic
    @Column(name = "evaluada")
    public Boolean getEvaluada() {
        return evaluada;
    }

    public void setEvaluada(Boolean evaluada) {
        this.evaluada = evaluada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstrategiaEntity that = (EstrategiaEntity) o;
        return idEstrategia == that.idEstrategia &&
                Objects.equals(puntos, that.puntos) &&
                Objects.equals(nombre, that.nombre) &&
                Objects.equals(fecha, that.fecha) &&
                Objects.equals(idProfesor, that.idProfesor) &&
                Objects.equals(habilitada, that.habilitada) &&
                Objects.equals(evaluada, that.evaluada);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEstrategia, puntos, nombre, fecha, idProfesor, habilitada, evaluada);
    }

    @OneToMany(mappedBy = "estrategia")
    public Collection<EstrategiaGrupoEntity> getGrupos() {
        return grupos;
    }

    public void setGrupos(Collection<EstrategiaGrupoEntity> estrategiaGruposByIdEstrategia) {
        this.grupos = estrategiaGruposByIdEstrategia;
    }

    @OneToMany(mappedBy = "estrategia")
    public Collection<EstrategiaTemaEntity> getTemas() {
        return temas;
    }

    public void setTemas(Collection<EstrategiaTemaEntity> estrategiaTemasByIdEstrategia) {
        this.temas = estrategiaTemasByIdEstrategia;
    }

    @OneToMany(mappedBy = "estrategia")
    public Collection<JugadorDesafioEntity> getDesafios() {
        return desafios;
    }

    public void setDesafios(Collection<JugadorDesafioEntity> jugadorDesafiosByIdEstrategia) {
        this.desafios = jugadorDesafiosByIdEstrategia;
    }

    @OneToMany(mappedBy = "estrategia")
    public Collection<JugadorEstrategiaEntity> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Collection<JugadorEstrategiaEntity> jugadorEstrategiasByIdEstrategia) {
        this.jugadores = jugadorEstrategiasByIdEstrategia;
    }

    @OneToMany(mappedBy = "estrategiaByIdEstrategia")
    public Collection<EstrategiaPreguntaEntity> getEstrategiaPreguntasByIdEstrategia() {
        return estrategiaPreguntasByIdEstrategia;
    }

    public void setEstrategiaPreguntasByIdEstrategia(Collection<EstrategiaPreguntaEntity> estrategiaPreguntasByIdEstrategia) {
        this.estrategiaPreguntasByIdEstrategia = estrategiaPreguntasByIdEstrategia;
    }
}
