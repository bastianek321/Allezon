package pl.pjwstk.edu.jazapp.auction;


import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    private void addToDatabase(Auction auction){
        em.persist(auction);
    }


}
