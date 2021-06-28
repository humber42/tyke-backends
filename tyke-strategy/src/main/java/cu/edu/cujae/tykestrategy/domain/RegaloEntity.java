package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "regalo", schema = "public", catalog = "tyke-strategy")
public class RegaloEntity {
    private long idRegalo;

    private String descripcion;
    private Collection<JugadorRegaloEntity> jugadorRegalos;
    private TipoRegaloEntity tipoRegalo;
    private OtorgamientoEntity otorgamiento;

    @Id
    @Column(name = "id_regalo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdRegalo() {
        return idRegalo;
    }

    public void setIdRegalo(long idRegalo) {
        this.idRegalo = idRegalo;
    }


    @Basic
    @Column(name = "descripcion")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegaloEntity that = (RegaloEntity) o;
        return idRegalo == that.idRegalo &&
                Objects.equals(descripcion, that.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRegalo, descripcion);
    }

    @OneToMany(mappedBy = "regalo")
    public Collection<JugadorRegaloEntity> getJugadorRegalos() {
        return jugadorRegalos;
    }

    public void setJugadorRegalos(Collection<JugadorRegaloEntity> jugadorRegalosByIdRegalo) {
        this.jugadorRegalos = jugadorRegalosByIdRegalo;
    }

    @ManyToOne
    @JoinColumn(name = "id_tipo_regalo", referencedColumnName = "id_tipo_regalo")
    public TipoRegaloEntity getTipoRegalo() {
        return tipoRegalo;
    }

    public void setTipoRegalo(TipoRegaloEntity tipoRegaloByIdTipoRegalo) {
        this.tipoRegalo = tipoRegaloByIdTipoRegalo;
    }

    @ManyToOne
    @JoinColumn(name = "id_otorgamiento", referencedColumnName = "id_otorgamiento")
    public OtorgamientoEntity getOtorgamiento() {
        return otorgamiento;
    }

    public void setOtorgamiento(OtorgamientoEntity otorgamientoByIdOtorgamiento) {
        this.otorgamiento = otorgamientoByIdOtorgamiento;
    }
}
