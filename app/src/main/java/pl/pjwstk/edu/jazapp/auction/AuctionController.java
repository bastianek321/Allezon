package pl.pjwstk.edu.jazapp.auction;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    private Section section;

    public void add(String name){

    }

}
