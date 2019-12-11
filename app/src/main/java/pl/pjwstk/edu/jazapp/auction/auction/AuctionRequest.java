package pl.pjwstk.edu.jazapp.auction.auction;

import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Set;

@Named
@RequestScoped
public class AuctionRequest {

    private String title;
    private String description;
    private float price;
    private Long categoryId;
    private String owner;
    //private Set<Photo> photos;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    //    public Set<Photo> getPhotos() {
//        return photos;
//    }
//
//    public void setPhotos(Set<Photo> photos) {
//        this.photos = photos;
//    }
//
    @Override
    public String toString() {
        return "AddAuctionRequest{" +
                "title='" + title + '\'' +
                "description='" + description + '\'' +
                "price='" + price + '\'' +
                "category='" + categoryId + '\'' +
                "owner='" + owner + '\'' +
                //"photos='" + photos + '\'' +
                '}';
    }
}
