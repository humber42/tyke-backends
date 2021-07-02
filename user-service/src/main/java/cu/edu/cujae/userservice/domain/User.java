package cu.edu.cujae.userservice.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;


@NoArgsConstructor
public class User {

    private Long id;
    private String username;
    private String fullname;
    private String email;
    private String password;
    private Date dob;
    private String gender;
    private String lang;
    private List<Role> roles;
    private Integer loginAttempt;
    private String  status;
    private int id_profile;
    private String image_url;

    private List<String> rolesSelected;
    private String passwordConfirm;
    private String passwordNew;

    public User(Long id,String username,String fullname,String email,String password,Date dob,String gender,String lang,String status,Integer loginAttempt,int profile_id,String image_url){
        this.id =id;
        this.username = username;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.gender = gender;
        this.lang = lang;
        passwordConfirm = null;
        passwordNew = null;
        rolesSelected = new LinkedList<>();
        this.status = status;
        this.loginAttempt = loginAttempt;
        this.id_profile = profile_id;
        this.image_url = image_url;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public User(Long id, String username, String fullname, String email, List<Role>roles, String password, Date dob, String gender, String lang, String status, Integer loginAttempt, int profile_id, String image_url){
        this(id,username,fullname,email,password,dob,gender,lang,status,loginAttempt,profile_id,image_url);
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getLoginAttempt() {
        return loginAttempt;
    }

    public void setLoginAttempt(Integer loginAttempt) {
        this.loginAttempt = loginAttempt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public List<String> getRolesSelected() {
        return rolesSelected;
    }

    public void setRolesSelected(List<String> rolesSelected) {
        this.rolesSelected = rolesSelected;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    public String getPasswordNew() {
        return passwordNew;
    }

    public void setPasswordNew(String passwordNew) {
        this.passwordNew = passwordNew;
    }
}
