package cu.edu.cujae.tykenotifications.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "message", schema = "public", catalog = "tyke-notifications")
public class MessageEntity {
    private long id;
    private String message;
    private Long idFromUser;
    private Long idToUser;
    private Boolean received;
    private Boolean readed;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Basic
    @Column(name = "id_from_user")
    public Long getIdFromUser() {
        return idFromUser;
    }

    public void setIdFromUser(Long idFromUser) {
        this.idFromUser = idFromUser;
    }

    @Basic
    @Column(name = "id_to_user")
    public Long getIdToUser() {
        return idToUser;
    }

    public void setIdToUser(Long idToUser) {
        this.idToUser = idToUser;
    }

    @Basic
    @Column(name = "received")
    public Boolean getReceived() {
        return received;
    }

    public void setReceived(Boolean received) {
        this.received = received;
    }

    @Basic
    @Column(name = "readed")
    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MessageEntity that = (MessageEntity) o;
        return id == that.id &&
                Objects.equals(message, that.message) &&
                Objects.equals(idFromUser, that.idFromUser) &&
                Objects.equals(idToUser, that.idToUser) &&
                Objects.equals(received, that.received) &&
                Objects.equals(readed, that.readed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, message, idFromUser, idToUser, received, readed);
    }
}
