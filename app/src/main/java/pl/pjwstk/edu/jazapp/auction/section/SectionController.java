package pl.pjwstk.edu.jazapp.auction.section;


import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;

@Named
@RequestScoped
public class SectionController{
    @Inject
    SectionRequest sectionRequest;
    @Inject
    SectionRepository sectionRepository;

    public void add(){
        if(sectionRepository.checkIfSectionExists(sectionRequest.getName())){
            Section section = new Section(sectionRequest.getName());
            sectionRepository.addToDatabase(section);
            System.out.println("Added section "+sectionRequest.getName());
        }
        else System.out.println("Failed to create section "+sectionRequest.getName());
    }

    public void edit(String name){
        if(sectionRepository.checkIfSectionExists(sectionRequest.getName())){
            Section section = sectionRepository.getSectionByName(sectionRequest.getName());
            section.setName(name);
            sectionRepository.editSection(section);
        }

    }

    public List<Section> getAllSections(){
        return sectionRepository.getAllSections();
    }
}
