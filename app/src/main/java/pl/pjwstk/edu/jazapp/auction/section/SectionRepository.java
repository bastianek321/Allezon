package pl.pjwstk.edu.jazapp.auction.section;


import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class SectionRepository {


    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addToDatabase(Section section) {
        if (!checkIfSectionExists(section.getName())) {
            em.persist(section);
        }
    }


    public boolean checkIfSectionExists(String name) {
        var list = em.createQuery("from Section where name = :name", Section.class)
                .setParameter("name", name)
                .getResultList();

        return list.isEmpty();

    }
}
