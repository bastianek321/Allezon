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
    public void editAuction(Auction auction) {em.merge(auction);}

    @Transactional
    public Auction getAuctionById(Long id) { return em.find(Auction.class, id);}

    @Transactional
    public Category getCategoryById(Long id){
        return em.find(Category.class, id);
    }

    @Transactional
    public List<Auction> getAuctionsByUser(String user){
        ProfileEntity profile = em.find(ProfileEntity.class, user);
        return em.createQuery("from Auction where owner= :user", Auction.class)
            .setParameter("user", profile).getResultList();
    }

    @Transactional
    public List<Auction> getAllAuctions(){
        return em.createQuery("from Auction ", Auction.class).getResultList();
    }


}
