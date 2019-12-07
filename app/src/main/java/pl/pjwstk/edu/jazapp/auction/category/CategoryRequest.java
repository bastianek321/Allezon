package pl.pjwstk.edu.jazapp.auction.category;

import pl.pjwstk.edu.jazapp.auction.section.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryRequest {

    private String name;
    private Long sectionId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Section getSection() {
//        return section;
//    }
//
//    public void setSection(Section section) {
//        this.section = section;
//    }


    public Long getSectionId() {
        return sectionId;
    }

    public void setSectionId(Long sectionId) {
        this.sectionId = sectionId;
    }

    @Override
    public String toString() {
        return "AddParameterRequest{" +
                "name='" + name + '\'' +
                "section=" + sectionId + '\'' +
                '}';
    }
}
