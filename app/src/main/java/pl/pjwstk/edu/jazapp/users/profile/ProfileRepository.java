package pl.pjwstk.edu.jazapp.users.profile;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ProfileRepository {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void addToDatabase(ProfileEntity profile) {
        if (!checkIfUserExists(profile.getUsername())) {
            em.persist(profile);
        }
    }

    public String getUsername(String username) {

        String error = "This user doesnt exist";
        if (checkIfUserExists(username)) {
            return em.find(ProfileEntity.class, username).getUsername();
        } else return error;
    }

    public String getPassword(String username) {
        String error = "This user doesnt exist";
        if (checkIfUserExists(username)) {
            return em.find(ProfileEntity.class, username).getPassword();
        } else return error;
    }

    public boolean checkIfUserExists(String username) {
        ProfileEntity tmp = em.find(ProfileEntity.class, username);
        if(tmp == null){
            return false;
        }
        return true;
    }

    public String getSurname(String username) {
        return em.find(ProfileEntity.class, username).getSurname();
    }

    public String getName(String username) {
        return em.find(ProfileEntity.class, username).getName();
    }
}