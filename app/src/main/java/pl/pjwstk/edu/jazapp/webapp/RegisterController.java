package pl.pjwstk.edu.jazapp.webapp;

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
    private Users users;

    public void register() {
        String tmpname = registerRequest.getName();
        String tmpsurname = registerRequest.getSurname();
        String tmppassword = registerRequest.getPassword();
        String tmprepeatpassword = registerRequest.getRepeatpassword();
        String tmpusername = registerRequest.getUsername();
        String tmpemail = registerRequest.getEmail();
        String tmpbirthdate = registerRequest.getBirthdate();


        if (!users.checkIfUsernameExists(tmpusername)) {
            if (tmppassword.equals(tmprepeatpassword)) {
                User user = new User(tmpname, tmpsurname, tmppassword, tmpusername, tmpemail, tmpbirthdate);
                users.addToDatabase(user);
                System.out.println(tmpusername + " zarejestrowal sie.");
                FacesContext context = FacesContext.getCurrentInstance();
                HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
                try {
                    response.sendRedirect("login.xhtml");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

