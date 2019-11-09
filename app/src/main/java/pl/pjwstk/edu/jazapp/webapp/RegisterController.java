package pl.pjwstk.edu.jazapp.webapp;

import pl.pjwstk.edu.jazapp.auth.ProfileEntity;
import pl.pjwstk.edu.jazapp.auth.ProfileRepository;
import pl.pjwstk.edu.jazapp.register.RegisterRequest;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Named
@RequestScoped
public class RegisterController {
    @Inject
    private RegisterRequest registerRequest;
    @Inject
    private ProfileRepository repository;

    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
    private boolean usernameAlreadyExists = false;
    private boolean passwordsDoNotMatch = false;


    public void register() {
        if (!repository.checkIfUserExists(registerRequest.getUsername())) {
            if (registerRequest.getPassword().equals(registerRequest.getRepeatpassword())) {
                ProfileEntity profile = new ProfileEntity(registerRequest.getName(), registerRequest.getSurname(), registerRequest.getPassword(), registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getBirthdate());
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







