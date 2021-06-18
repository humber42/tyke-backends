package cu.edu.cujae.questionservice.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PistaPreguntaEntityPK implements Serializable {
    private long idPregunta;
    private long idPista;

    @Column(name = "id_pregunta")
    @Id
    public long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Column(name = "id_pista")
    @Id
    public long getIdPista() {
        return idPista;
    }

    public void setIdPista(long idPista) {
        this.idPista = idPista;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PistaPreguntaEntityPK that = (PistaPreguntaEntityPK) o;

        if (idPregunta != that.idPregunta) return false;
        if (idPista != that.idPista) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idPregunta ^ (idPregunta >>> 32));
        result = 31 * result + (int) (idPista ^ (idPista >>> 32));
        return result;
    }
}
