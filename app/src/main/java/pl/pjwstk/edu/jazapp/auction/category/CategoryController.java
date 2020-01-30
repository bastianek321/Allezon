package pl.pjwstk.edu.jazapp.auction.category;


import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.entities.Section;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class CategoryController {

    @Inject
    CategoryRequest categoryRequest;
    @Inject
    CategoryRepository categoryRepository;

    public void add(){
        if(categoryRepository.checkIfCategoryExists(categoryRequest.getName())){
            Section section = categoryRepository.getSectionById(categoryRequest.getSectionId());
            Category category = new Category(categoryRequest.getName(), section);
            categoryRepository.addToDatabase(category);
            System.out.println("Added category: "+categoryRequest.getName());
        }
        else System.out.println("Error adding category "+ categoryRequest.getName());
    }

    public void edit(){
        if(categoryRepository.checkIfCategoryExists(categoryRequest.getName())){
            Category category = categoryRepository.getCategoryById(categoryRequest.getId());
            category.setName(categoryRequest.getName());
            categoryRepository.editCategory(category);
        }

    }



}
