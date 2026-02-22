package in.lisa.billingSoftware.controller;

import in.lisa.billingSoftware.io.CategoryRequest;
import in.lisa.billingSoftware.io.CategoryResponse;
import in.lisa.billingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
//@RequiredArgsConstructor //Without this would have to add constructurs for CategoryService to be injected in this file
public class CategoryController {

    //Injecting category Service
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest request)
    {


        return categoryService.addCategory(request);
    }

    @GetMapping
    @ResponseStatus
    public List<CategoryResponse> fetchCategories()
    {
        return categoryService.read();
    }

}
