package pl.pjwstk.edu.jazapp.auction.category;


import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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

    @Transactional
    public void editCategory(Category category){
        if(checkIfCategoryExists(category.getName())){
            em.merge(category);
        }
    }

    @Transactional
    public List<Category> getAllCategories(){return em.createQuery("from Category ", Category.class).getResultList();}

    @Transactional
    public List<Category> getCategoriesBySectionId(Long id){
        return em.createQuery("from Category where section.id = :id", Category.class).setParameter("id", id).getResultList();
    }

    @Transactional
    public boolean checkIfCategoryExists(String name) {
        var list = em.createQuery("from Category where name= :name", Category.class)
                .setParameter("name", name)
                .getResultList();
        return list.isEmpty();
    }

    @Transactional
    public Category getCategoryByName(String name) {
        return em.createQuery("from Category where name=:name", Category.class)
                .setParameter("name", name)
                .getSingleResult();

    }

    @Transactional
    public Category getCategoryById(Long id){
        return em.find(Category.class, id);
    }

    @Transactional
    public Section getSectionByName(String name) {
        return em.createQuery("from Section where name= :name", Section.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public Section getSectionById(Long id){
        return em.createQuery("from Section where id = :id", Section.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
