package pl.pjwstk.edu.jazapp.users.login;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjwstk.edu.jazapp.users.profile.ProfileRepository;
import pl.pjwstk.edu.jazapp.users.SessionAllezon;


import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Named
@RequestScoped
public class LoginController {
    @Inject
    private LoginRequest loginRequest;
    @Inject
    private SessionAllezon session;
    @Inject
    private ProfileRepository profileRepository;

    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
    private boolean userDoesntExist;
    private boolean wrongPassword;

    public void login() {

        session.setAdmin(false);
        session.setLoggedIn(false);
        if (profileRepository.checkIfUserExists(loginRequest.getUsername())) {
            var passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(loginRequest.getPassword(), profileRepository.getPassword(loginRequest.getUsername()))) {
                session.setLoggedIn(true);
                session.setProfile(profileRepository.getUser(loginRequest.getUsername()));
                System.out.println(loginRequest.getUsername() + " zalogowal sie.");
                try {
                    response.sendRedirect("logged.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (profileRepository.isAdmin(session.getProfile().getUsername())) {
                    session.setAdmin(true);
                }

            } else setWrongPassword(true);

        } else setUserDoesntExist(true);
    }

    public void logout() {
        session.setAdmin(false);
        session.setLoggedIn(false);

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        try {
            response.sendRedirect("index.xhtml");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isUserDoesntExist() {
        return userDoesntExist;
    }

    public void setUserDoesntExist(boolean userDoesntExist) {
        this.userDoesntExist = userDoesntExist;
    }

    public boolean isWrongPassword() {
        return wrongPassword;
    }

    public void setWrongPassword(boolean wrongPassword) {
        this.wrongPassword = wrongPassword;
    }
}
