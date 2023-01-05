package invozone.ecommerce.shopping.repo;

import invozone.ecommerce.shopping.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
