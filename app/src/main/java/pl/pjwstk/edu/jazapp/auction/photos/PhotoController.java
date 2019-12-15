package pl.pjwstk.edu.jazapp.auction.photos;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PhotoController {

    @Inject
    PhotoRequest photoRequest;
    @Inject
    PhotoRepository photoRepository;

    public void add(){

    }

    public String getPhotos(Long auction){
        return photoRepository.getPhotoByAuction(auction);
    }
}
