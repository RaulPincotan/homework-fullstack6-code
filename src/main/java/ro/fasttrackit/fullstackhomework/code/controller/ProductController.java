package ro.fasttrackit.fullstackhomework.code.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ro.fasttrackit.fullstackhomework.code.entity.Category;
import ro.fasttrackit.fullstackhomework.code.entity.Product;
import ro.fasttrackit.fullstackhomework.code.exceptions.ResourceNotFoundException;
import ro.fasttrackit.fullstackhomework.code.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts(@RequestParam(required = false) Category category,
                                        @RequestParam(required = false) Double maxAmount) {
        return productService.getAllProducts(category, maxAmount);
    }

    @GetMapping("{productId}")
    public Product getProduct(@PathVariable int productId) {
        return productService.getProduct(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product with id " + productId + " does not exist"));
    }

    @PostMapping()
    Product addProduct(@RequestBody Product newProduct) {
        return productService.saveProduct(newProduct);
    }

    @DeleteMapping("{productId}")
    Product deleteProduct(@PathVariable Long productId) {
        return productService.deleteProduct(productId);
    }
}
