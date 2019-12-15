package pl.pjwstk.edu.jazapp.auction.auction;

import pl.pjwstk.edu.jazapp.auction.entities.Photo;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
@RequestScoped
public class AuctionRequest {

    private Long id;
    private String title;
    private String description;
    private float price;
    private Long categoryId;
    private Long sectionId;
    private String owner;
    private List<Photo> photos = new ArrayList<>();

//    public AuctionRequest() {
//
//    }

    public AuctionRequest() {
        photos.add(new Photo());
    }

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

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

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
