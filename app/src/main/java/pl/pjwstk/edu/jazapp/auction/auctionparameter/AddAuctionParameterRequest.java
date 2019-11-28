package pl.pjwstk.edu.jazapp.auction.auctionparameter;


import pl.pjwstk.edu.jazapp.auction.auction.Auction;
import pl.pjwstk.edu.jazapp.auction.parameter.Parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AddAuctionParameterRequest {

    private String value;
    private Auction auction;
    private Parameter parameter;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public Parameter getParameter() {
        return parameter;
    }

    public void setParameter(Parameter parameter) {
        this.parameter = parameter;
    }

    @Override
    public String toString() {
        return "AddAuctionParameterRequest{" +
                "value='" + value + '\'' +
                "auction='" + auction + '\'' +
                "parameter='" + parameter + '\'' +
                '}';
    }
}
