package pl.pjwstk.edu.jazapp.users.profile;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class ProfileEntity {
    private String name;
    private String surname;
    private String password;
    private String username;
    private String email;
    private String birthdate;
    private Boolean admin;

    public ProfileEntity() {
    }

    public ProfileEntity(String name, String surname, String password, String username, String email, String birthdate) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.username = username;
        this.email = email;
        this.birthdate = birthdate;
        this.admin = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Id
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}