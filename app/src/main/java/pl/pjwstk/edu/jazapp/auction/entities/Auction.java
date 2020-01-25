package pl.pjwstk.edu.jazapp.auction.entities;

import pl.pjwstk.edu.jazapp.users.profile.ProfileEntity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private float price;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category category;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "auctionId")
    private List<Photo> photos;

    @ManyToOne
    @JoinColumn(name = "owner")
    private ProfileEntity owner;

    public Auction(){}
    public Auction(String title, String description, float price, Category category ,ProfileEntity owner){
        this.title = title;
        this.description = description;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public ProfileEntity getOwner() {
        return owner;
    }

    public void setOwner(ProfileEntity owner) {
        this.owner = owner;
    }


}
