package cu.edu.cujae.tykenotifications.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "notifications", schema = "public", catalog = "tyke-notifications")
public class NotificationsEntity {
    private long id;
    private String notification;
    private Long idUsuario;
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
    @Column(name = "notification")
    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    @Basic
    @Column(name = "id_usuario")
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
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
        NotificationsEntity that = (NotificationsEntity) o;
        return id == that.id &&
                Objects.equals(notification, that.notification) &&
                Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(readed, that.readed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, notification, idUsuario, readed);
    }
}
