package bitc.prac.boot02.services;

import bitc.prac.boot02.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository
		extends JpaRepository<Product, Integer> {
}
