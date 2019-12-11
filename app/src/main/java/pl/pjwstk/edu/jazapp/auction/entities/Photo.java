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

    public Photo() {}
    public Photo(String path, Auction auction){
        this.path = path;
        this.auction = auction;
    }
}
