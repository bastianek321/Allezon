package pl.pjwstk.edu.jazapp.auction.photos;


import pl.pjwstk.edu.jazapp.auction.entities.Auction;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class PhotoRequest {

    private String path;
    private Auction auction;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    @Override
    public String toString() {
        return "AddPhotosRequest{" +
                "path='" + path + '\'' +
                "auction='" + auction + '\'' +
                '}';
    }
}
