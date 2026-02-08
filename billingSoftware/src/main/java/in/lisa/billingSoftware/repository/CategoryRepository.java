package in.lisa.billingSoftware.repository;

import in.lisa.billingSoftware.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//Extending JpaRepository gives CRUD operations for an entity without writing database code.
//💡 Together:
//JpaRepository<CategoryEntity, Long> means
//→ “Manage CategoryEntity records whose primary key is of type Long.”
//This interface tells Spring Data JPA to automatically generate CRUD and database operations for CategoryEntity using Long as its primary key type.

public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {

}
