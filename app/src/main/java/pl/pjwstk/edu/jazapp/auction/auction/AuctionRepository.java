package pl.pjwstk.edu.jazapp.auction.auction;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.users.profile.ProfileEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addToDatabase(Auction auction){
        em.persist(auction);
    }

    @Transactional
    public Category getCategoryByName(String name){
        return em.createQuery("from Category where name=:name", Category.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Transactional
    public Category getCategoryById(Long id){
        return em.find(Category.class, id);
    }

    @Transactional
    public ProfileEntity getOwner(String username){
        return  em.find(ProfileEntity.class, username);
    }

    @Transactional
    public List<Category> getAllCategories(){
        return em.createQuery("from Category ", Category.class).getResultList();
    }

    @Transactional
    public List<Auction> getAllAuctions(){
        return em.createQuery("from Auction ", Auction.class).getResultList();
    }


}
