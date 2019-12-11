package pl.pjwstk.edu.jazapp.auction.photos;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class PhotoRepository {

    @PersistenceContext
    EntityManager em;


    @Transactional
    public void addToDatabase(Photo photo){
        em.persist(photo);
    }

    @Transactional
    public Photo getPhotoById(Long id){
        return em.find(Photo.class, id);
    }

    @Transactional
    public Photo getPhotoByPath(String path){
        return em.createQuery("from Photo where path= :path", Photo.class)
                .setParameter("path", path)
                .getSingleResult();
    }

    @Transactional
    public Auction getAuctionById(Long id){
        return em.find(Auction.class, id);
    }
}
