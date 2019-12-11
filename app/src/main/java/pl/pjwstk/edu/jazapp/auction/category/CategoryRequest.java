package pl.pjwstk.edu.jazapp.auction.category;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequest {

    private String name;
    private Long id;
    private Long sectionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "AddParameterRequest{" +
                "name='" + name + '\'' +
                "section=" + sectionId + '\'' +
                '}';
    }
}
