package in.lisa.billingSoftware.service;

import in.lisa.billingSoftware.io.CategoryRequest;
import in.lisa.billingSoftware.io.CategoryResponse;

public interface CategoryService {
   CategoryResponse addCategory(CategoryRequest request);

}
