package pl.pjwstk.edu.jazapp.auction.auction;



import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class AuctionController {

    @Inject
    AuctionRequest auctionRequest;
    @Inject
    AuctionRepository auctionRepository;

    public void add(){
        Auction auction = new Auction(auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(),
                auctionRepository.getCategoryById(auctionRequest.getCategoryId()), auctionRepository.getOwner(auctionRequest.getOwner()));
        auctionRepository.addToDatabase(auction);
        System.out.println("Added auction: "+auction.getTitle()+ " "+auction.getId());
    }

    public List<Category> getAllCategories(){ return auctionRepository.getAllCategories();}

    public List<Auction> getAllAuctions(){ return auctionRepository.getAllAuctions();}

}
