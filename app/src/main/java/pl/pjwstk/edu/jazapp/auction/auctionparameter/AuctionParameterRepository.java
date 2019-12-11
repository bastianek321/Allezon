package pl.pjwstk.edu.jazapp.auction.auctionparameter;

import pl.pjwstk.edu.jazapp.auction.entities.AuctionParameter;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class AuctionParameterRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void addToDatabase(AuctionParameter auctionParameter){
        em.persist(auctionParameter);
    }
}
