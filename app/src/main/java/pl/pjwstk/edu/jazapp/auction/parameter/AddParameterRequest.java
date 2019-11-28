package pl.pjwstk.edu.jazapp.auction.parameter;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AddParameterRequest {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddParameterRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}
