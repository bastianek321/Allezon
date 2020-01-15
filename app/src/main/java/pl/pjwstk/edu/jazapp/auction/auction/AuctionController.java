package pl.pjwstk.edu.jazapp.auction.auction;



import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;
import pl.pjwstk.edu.jazapp.utils.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionController {
    @Inject
    AuctionCreatorService creatorService;
    @Inject
    AuctionRequest auctionRequest;
    @Inject
    AuctionRepository auctionRepository;
    @Inject
    ParamRetriever paramRetriever;


    public void add(){
        Auction auction = new Auction(auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(),
                auctionRepository.getCategoryById(auctionRequest.getCategoryId()), creatorService.getOwner() );
        Photo photo = new Photo(auctionRequest.getPhotos().get(0).getPath(), auction);
        auctionRepository.addToDatabase(auction);
        creatorService.addPhoto(photo);
        System.out.println("Added auction: "+auction.getTitle()+ " "+auction.getId());
    }

    public List<Auction> getAllAuctions(){ return auctionRepository.getAllAuctions();}

    public List<Auction> getMyAuctions() {return  auctionRepository.getAuctionsByUser(creatorService.getOwner().getUsername());}

    public Auction getAuction() {
        if(paramRetriever.contains("auction")){
            return auctionRepository.getAuctionById(paramRetriever.getLong("auction"));
        }
        else return null;

    }

}
