package pl.pjwstk.edu.jazapp.webapp;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class Users {

    private List<User> users = new ArrayList<User>();


    boolean checkIfUsernameExists(String username){

        for (User user : users) {
            return user.getUsername().equals(username);
        }
        return false;
    }

    void addToDatabase(User user){
        users.add(user);
    }

    public String checkPassword(String username){
        String tmp = "Password invalid";
        for(User user : users){
            if(user.getUsername().equals(username)){
                tmp = user.getPassword();
            }
        }
        return tmp;
    }


}
