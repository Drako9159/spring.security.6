package drako.springsecurity.repository;

import drako.springsecurity.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepository extends JpaRepository<ProductDto, Long> {
}
