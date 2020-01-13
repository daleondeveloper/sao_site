package com.daleondeveloper.swordartonline_site.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

//POJO object of user
//For login in site
@Entity
@Table(name = "Users")
public class User extends BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Password")
    private String password;


    @JoinColumn(name = "Nickname")
    private String nickname;

    @JoinColumn(name = "access")
    private String access;

    //Image

    @Lob
    private byte[] image_main;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
    joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<UserRole> roles;

    //Date and Time
    private LocalDate lastUpdateDate;

    public User() {
    }

    public User(String email, String password, List<UserRole> roles) {
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public User(String mail, String password){
        this.setEmail(mail);
        this.setPassword(password);
    }

    public User(String email, String password, String nickname, String access, byte[] image_main, List<UserRole> roles, LocalDate lastUpdateDate) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.access = access;
        this.image_main = image_main;
        this.roles = roles;
        this.lastUpdateDate = lastUpdateDate;
    }


    public byte[] getImage_main() {
        return image_main;
    }

    public void setImage_main(byte[] image_main) {
        this.image_main = image_main;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAccess() {
        return access;
    }

    public void setAccess(String access) {
        this.access = access;
    }

    public LocalDate getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(LocalDate lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(List<UserRole> roles) {
        this.roles = roles;
    }
}
