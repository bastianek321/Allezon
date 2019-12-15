package pl.pjwstk.edu.jazapp.auction.entities;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "auctionId")
    private Auction auction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Photo() {}

    public Photo(String path, Auction auction){
        this.path = path;
        this.auction = auction;
    }


}
