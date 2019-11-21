package pl.pjwstk.edu.jazapp.auction;

import javax.persistence.*;

@Entity
@Table(name = "auction_parameter")
public class AuctionParameter {

    @EmbeddedId
    private AuctionParameterId id;

    @Column(name = "value")
    private String value;

    @OneToOne
    @JoinColumn(name = "auctionId",insertable = false, updatable = false)
    private Auction auction;

    @ManyToOne
    @JoinColumn(name = "parameterId")
    private Parameter parameter;

    public AuctionParameter(){}
    public AuctionParameter(String value, Auction auction, Parameter parameter){
        this.value = value;
        this.auction= auction;
        this.parameter = parameter;
    }


}
