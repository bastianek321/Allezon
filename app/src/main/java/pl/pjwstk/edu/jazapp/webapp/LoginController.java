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

    private FacesContext context = FacesContext.getCurrentInstance();
    private HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();

    public void login() {
        if (users.checkIfUsernameExists(loginRequest.getUsername())) {
            String checkPassword  = users.checkPassword(loginRequest.getUsername());
            if (loginRequest.getPassword().equals(checkPassword)) {
                session.setLoggedIn(true);
                session.setSurname(users.getSurname(loginRequest.getUsername()));
                session.setName(users.getName(loginRequest.getUsername()));
                System.out.println(loginRequest.getUsername() + " zalogowal sie.");
                try {
                    response.sendRedirect("logged.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}