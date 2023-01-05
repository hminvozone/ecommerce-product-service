package invozone.ecommerce.shopping.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "category", schema = "\"ecommerce\"")
@Entity
public class Category {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "category_name")
    private String categoryName;
    private String thumbnail;

}
