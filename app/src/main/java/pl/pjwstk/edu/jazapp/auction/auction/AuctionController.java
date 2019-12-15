package pl.pjwstk.edu.jazapp.auction.auction;



import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;
import pl.pjwstk.edu.jazapp.users.SessionAllezon;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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


    public void add(){
        Auction auction = new Auction(auctionRequest.getTitle(), auctionRequest.getDescription(), auctionRequest.getPrice(),
                auctionRepository.getCategoryById(auctionRequest.getCategoryId()), creatorService.getOwner() );
        Photo photo = new Photo(auctionRequest.getPhotos().get(0).getPath(), auction);
        auctionRepository.addToDatabase(auction);
        creatorService.addPhoto(photo);
        System.out.println("Added auction: "+auction.getTitle()+ " "+auction.getId());
    }


//    public Auction showAuction(){
//        HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
//        HttpServletResponse res = (HttpServletResponse)FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        return auctionRepository.getAuctionById(req.getParameter("auction"));
//    }

    public List<Auction> getAllAuctions(){ return auctionRepository.getAllAuctions();}

    public List<Auction> getMyAuctions() {return  auctionRepository.getAuctionsByUser(creatorService.getOwner().getUsername());}

    public Auction getAuction(Long id) {return auctionRepository.getAuctionById(id);}

//    public void edit(Long id){
//        Auction auction = getAuction(id);
//        auction.setCategory(auctionRepository.getCategoryById(auctionRequest.getCategoryId()));
//        auction.setDescription(auctionRequest.getDescription());
//        auction.setPrice(auctionRequest.getPrice());
//        auction.setTitle(auctionRequest.getTitle());
//        auctionRepository.editAuction(auction);
//    }
}
