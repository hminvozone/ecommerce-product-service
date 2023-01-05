package invozone.ecommerce.shopping.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductDto {
    private String productName;
    private String description;
    private double price;
    private double discountPrice;
    private String thumbnail;
    private Integer categoryId;
}
