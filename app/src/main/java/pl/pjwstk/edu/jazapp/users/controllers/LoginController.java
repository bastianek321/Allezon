package pl.pjwstk.edu.jazapp.users.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjwstk.edu.jazapp.users.repositories.ProfileRepository;
import pl.pjwstk.edu.jazapp.users.requests.LoginRequest;
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
        if (profileRepository.checkIfUserExists(loginRequest.getUsername())) {
            var passwordEncoder = new BCryptPasswordEncoder();
            if (passwordEncoder.matches(loginRequest.getPassword(),profileRepository.getPassword(loginRequest.getUsername()))) {
                session.setLoggedIn(true);
                session.setSurname(profileRepository.getSurname(loginRequest.getUsername()));
                session.setName(profileRepository.getName(loginRequest.getUsername()));
                System.out.println(loginRequest.getUsername() + " zalogowal sie.");
                try {
                    response.sendRedirect("logged.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else setWrongPassword(true);

        } else setUserDoesntExist(true);
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
