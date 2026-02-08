//Service Implementation cclass, business Logic lies here
package in.lisa.billingSoftware.service.impl;

import in.lisa.billingSoftware.entity.CategoryEntity;
import in.lisa.billingSoftware.io.CategoryRequest;
import in.lisa.billingSoftware.io.CategoryResponse;
import in.lisa.billingSoftware.repository.CategoryRepository;
import in.lisa.billingSoftware.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static java.util.stream.Stream.builder;



@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse addCategory(CategoryRequest request)
    {

        //COnvert Request object to entity object
        CategoryEntity newCategory =  convertToEntity(request);
        //Using the repository to save the newly created entity into the database
        newCategory = categoryRepository.save(newCategory);

        //convert newCategory to Response


        return convertToResponse(newCategory);


    }

    private CategoryResponse convertToResponse(CategoryEntity newCategory) {
          return CategoryResponse.builder()
                    .categoryId(newCategory.getCategoryId())
                    .name(newCategory.getName())
                    .description(newCategory.getDescription())
                    .bgColor(newCategory.getBgColor())
                    .imgUrl(newCategory.getImgUrl())
                    .createdAt(newCategory.getCreatedAt())
                    .updatedAt(newCategory.getUpdatedAt())
                    .build();



    }

    //The Builder Pattern allows clean, readable, and safe object creation,
    // especially when a class has many fields or optional values.
    private CategoryEntity convertToEntity(CategoryRequest categoryrequest) {

        return CategoryEntity.builder()
                    .categoryId(UUID.randomUUID().toString())
                    .name(categoryrequest.getName())
                    .description(categoryrequest.getDescription())
                    .bgColor(categoryrequest.getBgColor())
                    .build();



    }

}
