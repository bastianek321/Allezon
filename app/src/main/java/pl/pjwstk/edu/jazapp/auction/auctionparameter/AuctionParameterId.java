package pl.pjwstk.edu.jazapp.auction.auctionparameter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AuctionParameterId implements Serializable {

    @Column(name = "auctionId")
    private Long auctionId;

    @Column(name = "parameterId")
    private Long paremeterId;
}
