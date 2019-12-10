package pl.pjwstk.edu.jazapp.auction.category;


import pl.pjwstk.edu.jazapp.auction.section.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class CategoryRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addToDatabase(Category category) {
        if (checkIfCategoryExists(category.getName())) {
            em.persist(category);
        }
    }

    public boolean checkIfCategoryExists(String name) {
        var list = em.createQuery("from Category where name= :name", Category.class)
                .setParameter("name", name)
                .getResultList();
        return list.isEmpty();
    }

    public Category getCategoryByName(String name) {
        return em.createQuery("from Category where name=:name", Category.class)
                .setParameter("name", name)
                .getSingleResult();

    }

    public Category getCategoryById(Long id){
        return em.find(Category.class, id);
    }

    public Section getSectionByName(String name) {
        return em.createQuery("from Section where name= :name", Section.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    public Section getSectionById(Long id){
        return em.createQuery("from Section where id = :id", Section.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
