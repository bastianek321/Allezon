package pl.pjwstk.edu.jazapp.auction.photos;


import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class PhotoController {

    @Inject
    PhotoRequest photoRequest;
    @Inject
    PhotoRepository photoRepository;

    public void add(){
    }
}
