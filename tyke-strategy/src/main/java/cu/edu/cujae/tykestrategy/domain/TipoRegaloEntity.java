package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_regalo", schema = "public", catalog = "tyke-strategy")
public class TipoRegaloEntity {
    private long idTipoRegalo;
    private String nombre;


    @Id
    @Column(name = "id_tipo_regalo")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdTipoRegalo() {
        return idTipoRegalo;
    }

    public void setIdTipoRegalo(long idTipoRegalo) {
        this.idTipoRegalo = idTipoRegalo;
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
        TipoRegaloEntity that = (TipoRegaloEntity) o;
        return idTipoRegalo == that.idTipoRegalo &&
                Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTipoRegalo, nombre);
    }


}
