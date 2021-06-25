package cu.edu.cujae.questionservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "feedback", schema = "public", catalog = "tyke-questions")
public class FeedbackEntity {
    private long id;
    private String feedback;
    private Long idPregunta;
    private String username;
    private PreguntaEntity preguntaByIdPregunta;

    @Id
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "feedback")
    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    @Basic
    @Column(name = "id_pregunta")
    public Long getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(Long idPregunta) {
        this.idPregunta = idPregunta;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackEntity that = (FeedbackEntity) o;
        return id == that.id &&
                Objects.equals(feedback, that.feedback) &&
                Objects.equals(idPregunta, that.idPregunta) &&
                Objects.equals(username, that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, feedback, idPregunta, username);
    }

    @ManyToOne
    @JoinColumn(name = "id_pregunta", referencedColumnName = "id")
    public PreguntaEntity getPreguntaByIdPregunta() {
        return preguntaByIdPregunta;
    }

    public void setPreguntaByIdPregunta(PreguntaEntity preguntaByIdPregunta) {
        this.preguntaByIdPregunta = preguntaByIdPregunta;
    }
}
