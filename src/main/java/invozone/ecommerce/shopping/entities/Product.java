package invozone.ecommerce.shopping.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "\"ecommerce\"")
@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "product_name")
    private String productName;
    private String description;
    private double price;
    @Column(name = "discount_price")
    private double discountPrice;
    private String thumbnail;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category categoryId;
}
