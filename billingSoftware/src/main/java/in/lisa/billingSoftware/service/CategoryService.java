package in.lisa.billingSoftware.service;

import in.lisa.billingSoftware.io.CategoryRequest;
import in.lisa.billingSoftware.io.CategoryResponse;

import java.util.List;

public interface CategoryService {
   CategoryResponse addCategory(CategoryRequest request);

   List<CategoryResponse> read();

}
