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

    @Transactional
    public ProfileEntity getUser(String username) {
        return em.find(ProfileEntity.class, username);
    }

    @Transactional
    public String getUsername(String username) {

        String error = "This user doesnt exist";
        if (checkIfUserExists(username)) {
            return em.find(ProfileEntity.class, username).getUsername();
        } else return error;
    }

    @Transactional
    public boolean isAdmin(String username){
        return em.find(ProfileEntity.class, username).isAdmin();
    }

    @Transactional
    public String getPassword(String username) {
        String error = "This user doesnt exist";
        if (checkIfUserExists(username)) {
            return em.find(ProfileEntity.class, username).getPassword();
        } else return error;
    }

    @Transactional
    public boolean checkIfUserExists(String username) {
        ProfileEntity tmp = em.find(ProfileEntity.class, username);
        if (tmp == null) {
            return false;
        }
        return true;
    }
}