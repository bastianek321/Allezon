package pl.pjwstk.edu.jazapp.auction.photos;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class PhotoRepository {

    @PersistenceContext
    EntityManager em;


    @Transactional
    public void addToDatabase(Photo photo){
        em.persist(photo);
    }

    @Transactional
    public void editPhoto(Photo photo){em.merge(photo);}

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
    public Photo getPhotoByAuction(Long id){
        return em.createQuery("from Photo where auction.id = :id", Photo.class).setParameter("id", id).getSingleResult();
    }
}
