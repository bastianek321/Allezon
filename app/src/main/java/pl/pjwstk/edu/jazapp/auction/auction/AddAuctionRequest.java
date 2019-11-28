package pl.pjwstk.edu.jazapp.auction.auction;

import pl.pjwstk.edu.jazapp.auction.category.Category;
import pl.pjwstk.edu.jazapp.auction.photos.Photos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.Set;

@Named
@RequestScoped
public class AddAuctionRequest {

    private String title;
    private String description;
    private float price;
    private Category category;
    private Set<Photos> photos;

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Photos> getPhotos() {
        return photos;
    }

    public void setPhotos(Set<Photos> photos) {
        this.photos = photos;
    }
    @Override
    public String toString() {
        return "AddAuctionRequest{" +
                "title='" + title + '\'' +
                "description='" + description + '\'' +
                "price='" + price + '\'' +
                "category='" + category + '\'' +
                "photos='" + photos + '\'' +
                '}';
    }
}
