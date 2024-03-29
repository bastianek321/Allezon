package pl.pjwstk.edu.jazapp.users.register;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.pjwstk.edu.jazapp.users.SessionAllezon;
import pl.pjwstk.edu.jazapp.users.profile.ProfileEntity;
import pl.pjwstk.edu.jazapp.users.profile.ProfileRepository;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;
    @Inject
    private ProfileRepository repository;
    @Inject
    private SessionAllezon sessionAllezon;

    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
    private boolean usernameAlreadyExists = false;
    private boolean passwordsDoNotMatch = false;

    @Transactional
    public void register() {
        sessionAllezon.setAdmin(false);
        sessionAllezon.setLoggedIn(false);
        if (!repository.checkIfUserExists(registerRequest.getUsername())) {
            if (registerRequest.getPassword().equals(registerRequest.getRepeatpassword())) {
                ProfileEntity profile = new ProfileEntity(registerRequest.getName(), registerRequest.getSurname(), hashPassword(), registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getBirthdate());
                repository.addToDatabase(profile);
                System.out.println(profile.getUsername() + " zarejestrowal sie.");

                try {
                    response.sendRedirect("login.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else setPasswordsDoNotMatch(true);

        } else setUsernameAlreadyExists(true);
    }

    private String hashPassword(){
        var passwordEncoder = new BCryptPasswordEncoder();
        String rawPassword = registerRequest.getPassword();
        return passwordEncoder.encode(rawPassword);
    }

    public boolean isUsernameAlreadyExists() {
        return usernameAlreadyExists;
    }

    public void setUsernameAlreadyExists(boolean usernameAlreadyExists) {
        this.usernameAlreadyExists = usernameAlreadyExists;
    }

    public boolean isPasswordsDoNotMatch() {
        return passwordsDoNotMatch;
    }

    public void setPasswordsDoNotMatch(boolean passwordsDoNotMatch) {
        this.passwordsDoNotMatch = passwordsDoNotMatch;
    }
}







