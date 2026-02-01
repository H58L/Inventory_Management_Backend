package in.lisa.billingSoftware.io;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Builder
@Data
public class CategoryRequest {

    private String name;
    private String description;
    private String bgColor;
    private String imgUrl;

}



