package pl.pjwstk.edu.jazapp.auction.section;


import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class SectionRepository {


    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addToDatabase(Section section) {
        em.persist(section);
    }


    @Transactional
    public boolean checkIfSectionExists(String name) {
        var list = em.createQuery("from Section where name = :name", Section.class)
                .setParameter("name", name)
                .getResultList();

        return list.isEmpty();

    }

    @Transactional
    public Section getSectionByName(String name) {
        return em.createQuery("from Section where name= :name", Section.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public Section getSectionById(Long id){
        return em.find(Section.class, id);
    }

    @Transactional
    public List<Section> getAllSections(){
        return em.createQuery("from Section", Section.class)
                .getResultList();
    }

    @Transactional
    public void editSection(Section section) {
        em.merge(section);
    }
}
