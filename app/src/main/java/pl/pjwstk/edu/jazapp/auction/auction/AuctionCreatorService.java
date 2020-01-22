package pl.pjwstk.edu.jazapp.auction.auction;


import pl.pjwstk.edu.jazapp.auction.category.CategoryRepository;
import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.entities.Photo;
import pl.pjwstk.edu.jazapp.auction.entities.Section;
import pl.pjwstk.edu.jazapp.auction.photos.PhotoRepository;
import pl.pjwstk.edu.jazapp.auction.section.SectionRepository;
import pl.pjwstk.edu.jazapp.users.SessionAllezon;
import pl.pjwstk.edu.jazapp.users.profile.ProfileEntity;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class AuctionCreatorService {

    @Inject
    CategoryRepository categoryRepository;
    @Inject
    SectionRepository sectionRepository;
    @Inject
    SessionAllezon sessionAllezon;
    @Inject
    PhotoRepository photoRepository;

    public List<Section> getAllSections(){return sectionRepository.getAllSections();}

    public void addPhoto(Photo photo) {photoRepository.addToDatabase(photo);}

    public List<Category> getAllCategories(){
        return categoryRepository.getAllCategories();
    }

    public ProfileEntity getOwner(){
        return sessionAllezon.getProfile();
    }
}