package pl.pjwstk.edu.jazapp.auction.repositories;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@ApplicationScoped
public class AuctionRepository {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    private void addToDatabase(Auction auction){
        em.persist(auction);
    }


}