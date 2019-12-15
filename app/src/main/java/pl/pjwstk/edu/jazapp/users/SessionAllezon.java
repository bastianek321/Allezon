package pl.pjwstk.edu.jazapp.users;

import pl.pjwstk.edu.jazapp.users.profile.ProfileEntity;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

@Named
@SessionScoped
public class SessionAllezon implements Serializable {
    private boolean loggedIn = false;
    private ProfileEntity profile;
    private boolean admin = false;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public ProfileEntity getProfile() {
        return profile;
    }

    public void setProfile(ProfileEntity profile) {
        this.profile = profile;
    }

    public boolean isAdmin() {
        return this.admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }



}
