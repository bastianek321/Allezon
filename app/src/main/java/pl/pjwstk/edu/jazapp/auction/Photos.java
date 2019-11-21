package pl.pjwstk.edu.jazapp.auction;

import javax.persistence.*;

@Entity
@Table(name = "photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "path")
    private String path;

    @Column(name = "auctionId")
    private Long auction;


}
