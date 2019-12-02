package pl.pjwstk.edu.jazapp.auction.photos;

import pl.pjwstk.edu.jazapp.auction.auction.Auction;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "path")
    private String path;

    @ManyToOne
    @JoinColumn(name = "auctionId")
    private Auction auction;


}
