package pl.pjwstk.edu.jazapp.auction.auction;

import pl.pjwstk.edu.jazapp.auction.entities.Auction;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;
import pl.pjwstk.edu.jazapp.utils.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Named
@RequestScoped
public class AuctionEditController {

    @Inject
    AuctionRepository auctionRepository;
    @Inject
    ParamRetriever paramRetriever;
    @Inject
    AuctionCreatorService service;

    AuctionRequest request;



    public void edit(){
        Long auctionId = getRequest().getId();
        Auction auction;
        if(auctionId != null) {
            auction = auctionRepository.getAuctionById(auctionId);
            auction.setTitle(request.getTitle());
            auction.setPrice(request.getPrice());
            auction.setDescription(request.getDescription());
            auction.setCategory(auctionRepository.getCategoryById(request.getCategoryId()));
            Photo photo = service.getPhotoByAuction(auction.getId());
            var id = photo.getAuction().getId();
            photo.setPath(request.getPhotos().get(0).getPath());
            auctionRepository.editAuction(auction);
            service.editPhoto(photo);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            try {
                response.sendRedirect("showauction.xhtml?auction=" + auction.getId());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else System.out.println("Auction going by this ID does not exist");
    }

    public AuctionRequest getRequest() {
        if(request==null){
            request = createRequest();
        }
        return request;
    }

    private AuctionRequest createRequest() {
        if(paramRetriever.contains("edit")){
            Long id = paramRetriever.getLong("edit");
            return new AuctionRequest(auctionRepository.getAuctionById(id));
        }
        return new AuctionRequest();
    }
}
