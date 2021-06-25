package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "tipo_pregunta", schema = "public", catalog = "tyke-questions")
public class TipoPreguntaEntity {
    private long id;
    private String tipo;
    private Collection<PreguntaEntity> preguntasById;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "tipo")
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoPreguntaEntity that = (TipoPreguntaEntity) o;
        return id == that.id &&
                Objects.equals(tipo, that.tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tipo);
    }

    @OneToMany(mappedBy = "tipoPreguntaByIdTipoPregunta")
    public Collection<PreguntaEntity> getPreguntasById() {
        return preguntasById;
    }

    public void setPreguntasById(Collection<PreguntaEntity> preguntasById) {
        this.preguntasById = preguntasById;
    }
}
