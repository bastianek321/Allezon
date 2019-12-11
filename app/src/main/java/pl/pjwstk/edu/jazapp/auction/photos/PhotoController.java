package pl.pjwstk.edu.jazapp.auction.photos;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

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
