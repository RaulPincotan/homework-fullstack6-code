package ro.fasttrackit.fullstackhomework.code.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.fasttrackit.fullstackhomework.code.entity.Category;
import ro.fasttrackit.fullstackhomework.code.entity.Product;
import ro.fasttrackit.fullstackhomework.code.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository repository;

    public List<Product> getAllProducts(Category category,
                                        Double maxAmount) {

        if (category == null && maxAmount == null) {
            return repository.findAll();
        }

        if (category == null) {
            return repository.findAll()
                    .stream()
                    .filter(p -> p.getPrice() <= maxAmount)
                    .collect(Collectors.toList());
        } else if (maxAmount == null) {
            return repository.findAll()
                    .stream()
                    .filter(p -> p.getCategory() == category)
                    .collect(Collectors.toList());
        } else {
            return repository.findAll()
                    .stream()
                    .filter(p -> p.getCategory() == category)
                    .filter(p -> p.getPrice() <= maxAmount)
                    .collect(Collectors.toList());
        }

    }

    public Optional<Product> getProduct(long productId) {
        return repository.findById(productId);
    }

    public Product saveProduct(Product newProduct) {
        return repository.save(newProduct);
    }

    public Product deleteProduct(Long productId) {
        Optional<Product> dbProducts = repository.findById(productId);
        dbProducts.ifPresent(repository::delete);
        return dbProducts.orElse(null);
    }
}
