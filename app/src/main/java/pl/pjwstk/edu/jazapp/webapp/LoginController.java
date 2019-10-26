package pl.pjwstk.edu.jazapp.webapp;

import pl.pjwstk.edu.jazapp.login.LoginRequest;


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
    private Users users;
    @Inject
    private SessionAllezon session;

    public void login() {
        if (users.checkIfUsernameExists(loginRequest.getUsername())) {
            String check = users.checkPassword(loginRequest.getUsername());
            if (loginRequest.getPassword().equals(check)) {
                session.setLoggedIn(true);
                System.out.println(loginRequest.getUsername() + " zalogowal sie.");
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                try {
                    response.sendRedirect("logged.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}