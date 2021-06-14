package cu.edu.cujae.authservice.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "logs", schema = "public", catalog = "tyke-logs-auth")
public class LogsEntity {
    private long id;
    private String typeRequest;
    private String url;
    private String ipAdress;
    private String usernameEmail;

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
    @Column(name = "type_request")
    public String getTypeRequest() {
        return typeRequest;
    }

    public void setTypeRequest(String typeRequest) {
        this.typeRequest = typeRequest;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "ip_adress")
    public String getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(String ipAdress) {
        this.ipAdress = ipAdress;
    }

    @Basic
    @Column(name = "username_email")
    public String getUsernameEmail() {
        return usernameEmail;
    }

    public void setUsernameEmail(String usernameEmail) {
        this.usernameEmail = usernameEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LogsEntity that = (LogsEntity) o;
        return id == that.id &&
                Objects.equals(typeRequest, that.typeRequest) &&
                Objects.equals(url, that.url) &&
                Objects.equals(ipAdress, that.ipAdress) &&
                Objects.equals(usernameEmail, that.usernameEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeRequest, url, ipAdress, usernameEmail);
    }
}
