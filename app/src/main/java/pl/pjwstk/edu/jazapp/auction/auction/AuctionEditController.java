package pl.pjwstk.edu.jazapp.auction.auction;

import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.utils.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class AuctionEditController {

    @Inject
    AuctionRepository auctionRepository;
    @Inject
    ParamRetriever paramRetriever;

    public Auction getAuctionById(){
        if(paramRetriever.contains("auction")){
            try {
                var auctionId = paramRetriever.getLong("auction");
                return auctionRepository.getAuctionById(auctionId);
            } catch (NumberFormatException e){
                return null;
            }

        }
        else return null;

    }

}
