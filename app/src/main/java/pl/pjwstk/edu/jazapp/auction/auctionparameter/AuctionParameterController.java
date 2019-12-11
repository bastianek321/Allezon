package pl.pjwstk.edu.jazapp.auction.auctionparameter;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionParameterController {

    @Inject
    AuctionParameterRequest auctionParameterRequest;


}
