package pl.pjwstk.edu.jazapp.auction.section;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class SectionController{
    @Inject
    AddSectionRequest sectionRequest;
    @Inject
    SectionRepository sectionRepository;

    public void add(){
        Section section = new Section(sectionRequest.getName());
        if(sectionRepository.checkIfSectionExists(sectionRequest.getName())){
            sectionRepository.addToDatabase(section);
        }
        else System.out.println("Failed to create section "+sectionRequest.getName());
    }
}
