package pl.pjwstk.edu.jazapp.auction.category;

import pl.pjwstk.edu.jazapp.auction.auction.AuctionCreatorService;
import pl.pjwstk.edu.jazapp.auction.entities.Category;
import pl.pjwstk.edu.jazapp.auction.section.SectionRepository;
import pl.pjwstk.edu.jazapp.auction.section.SectionRequest;
import pl.pjwstk.edu.jazapp.utils.ParamRetriever;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Named
@RequestScoped
public class CategoryEditController {

    @Inject
    CategoryRepository categoryRepository;
    @Inject
    ParamRetriever paramRetriever;
    @Inject
    AuctionCreatorService service;
    @Inject
    SectionRepository sectionRepository;
    @Inject
    CategoryRequest request;

    CategoryRequest categoryRequest;
    SectionRequest sectionRequest;


    public List<Category> getCategoriesBySection(){
        Long sectionId = getSectionRequest().getId();
        if(sectionId!=null){
            return categoryRepository.getCategoriesBySectionId(sectionId);
        }
        return null;
    }


    public void edit(){
        if(categoryRepository.checkIfCategoryExists(categoryRequest.getName())){
            Category category = categoryRepository.getCategoryById(categoryRequest.getId());
            category.setName(categoryRequest.getName());
            categoryRepository.editCategory(category);
            FacesContext context = FacesContext.getCurrentInstance();
            HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
            try {
                response.sendRedirect("editcategory.xhtml");
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }

    public CategoryRequest getCategoryRequest() {
        if(categoryRequest==null){
            categoryRequest = createCategoryRequest();
        }
        return categoryRequest;
    }

    public SectionRequest getSectionRequest(){
        if(sectionRequest==null){
            sectionRequest = createSectionRequest();
        }
        return sectionRequest;
    }

    private CategoryRequest createCategoryRequest() {
        if(paramRetriever.contains("category")){
            Long id = paramRetriever.getLong("category");
            return new CategoryRequest(categoryRepository.getCategoryById(id));
        }
        return new CategoryRequest();
    }

    public SectionRequest createSectionRequest(){
        if(paramRetriever.contains("section")){
            Long id = paramRetriever.getLong("section");
            return new SectionRequest(sectionRepository.getSectionById(id));
        }
        return new SectionRequest();
    }
}
