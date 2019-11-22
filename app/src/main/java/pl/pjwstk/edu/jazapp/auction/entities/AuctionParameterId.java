package pl.pjwstk.edu.jazapp.auction.entities;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuctionParameterId implements Serializable {
    private Long auctionId;
    private Long paremeterId;
}
