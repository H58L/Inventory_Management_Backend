package in.lisa.billingSoftware.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

//The Entity models an object in the real world into Java, ir it creates anObject woth methods and variable
//@Entity is a JPA annotation that marks a Java class as an entity. An entity in JPA represents a table in a
//relational database schema. When you annotate a class with @Entity ,
//you're telling JPA that instances of this class are to be mapped to rows in a corresponding database table.
@Entity
@Table(name= "tbl_category")
@Builder
@Data
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String categoryId;

    @Column(unique = true)
    private String name;

    //Fields with no special constrainst
    private String description;
    private String bgColor;
    private String imgUrl;

    @CreationTimestamp
    @Column(updatable = false)
    private Timestamp createdAt; //TimeStamp data type of SQL

    @UpdateTimestamp
    private Timestamp updatedAt;
}
