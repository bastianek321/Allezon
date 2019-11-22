package pl.pjwstk.edu.jazapp.auction.requests.add;

import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class AddCategoryRequest {

    private String name;
    private Section section;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "AddParameterRequest{" +
                "name='" + name + '\'' +
                "section=" + section + '\'' +
                '}';
    }
}
