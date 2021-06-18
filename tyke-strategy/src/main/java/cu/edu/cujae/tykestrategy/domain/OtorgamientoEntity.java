package cu.edu.cujae.tykestrategy.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "otorgamiento", schema = "public", catalog = "tyke-strategy")
public class OtorgamientoEntity {
    private long idOtorgamiento;
    private Integer cantPuntos;
    private String otorgamiento;


    @Id
    @Column(name = "id_otorgamiento")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getIdOtorgamiento() {
        return idOtorgamiento;
    }

    public void setIdOtorgamiento(long idOtorgamiento) {
        this.idOtorgamiento = idOtorgamiento;
    }

    @Basic
    @Column(name = "cant_puntos")
    public Integer getCantPuntos() {
        return cantPuntos;
    }

    public void setCantPuntos(Integer cantPuntos) {
        this.cantPuntos = cantPuntos;
    }

    @Basic
    @Column(name = "otorgamiento")
    public String getOtorgamiento() {
        return otorgamiento;
    }

    public void setOtorgamiento(String otorgamiento) {
        this.otorgamiento = otorgamiento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtorgamientoEntity that = (OtorgamientoEntity) o;
        return idOtorgamiento == that.idOtorgamiento &&
                Objects.equals(cantPuntos, that.cantPuntos) &&
                Objects.equals(otorgamiento, that.otorgamiento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idOtorgamiento, cantPuntos, otorgamiento);
    }


}
