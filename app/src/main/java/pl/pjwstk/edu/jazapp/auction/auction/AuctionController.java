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
        Photo photo1 = new Photo(auctionRequest.getPhotos().get(1).getPath(), auction);
        Photo photo2 = new Photo(auctionRequest.getPhotos().get(2).getPath(), auction);
        auctionRepository.addToDatabase(auction);
        creatorService.addPhoto(photo);
        creatorService.addPhoto(photo1);
        creatorService.addPhoto(photo2);
        System.out.println("Added auction: "+auction.getTitle()+ " "+auction.getId());
    }

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

    public List<Auction> getAllAuctions(){ return auctionRepository.getAllAuctions();}

    public List<Auction> getMyAuctions() {return  auctionRepository.getAuctionsByUser(creatorService.getOwner().getUsername());}


}
