package pl.pjwstk.edu.jazapp.auction.section;


import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionRequest {

    private String name;
    private Long id;

    public SectionRequest(Section section) {
        this.name = section.getName();
        this.id = section.getId();
    }

    public SectionRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                '}';
    }
}
