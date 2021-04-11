package ro.fasttrackit.fullstackhomework.code.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ro.fasttrackit.fullstackhomework.code.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
