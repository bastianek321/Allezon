package pl.pjwstk.edu.jazapp.auction.category;


import pl.pjwstk.edu.jazapp.auction.section.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

@Named
@RequestScoped
public class CategoryController {

    @Inject
    CategoryRequest categoryRequest;
    @Inject
    CategoryRepository categoryRepository;

    @Transactional
    public void add(){
        if(categoryRepository.checkIfCategoryExists(categoryRequest.getName())){
            Section section = categoryRepository.getSectionById(categoryRequest.getSectionId());
            Category category = new Category(categoryRequest.getName(), section);
            categoryRepository.addToDatabase(category);
            System.out.println("Added category: "+categoryRequest.getName());
        }
        else System.out.println("Error adding category "+ categoryRequest.getName());
    }

}
