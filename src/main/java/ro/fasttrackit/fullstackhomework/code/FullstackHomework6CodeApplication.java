package ro.fasttrackit.fullstackhomework.code;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import ro.fasttrackit.fullstackhomework.code.entity.Category;
import ro.fasttrackit.fullstackhomework.code.entity.Product;
import ro.fasttrackit.fullstackhomework.code.repository.ProductRepository;

import java.util.List;

@SpringBootApplication
public class FullstackHomework6CodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullstackHomework6CodeApplication.class, args);
    }

    @Bean
    CommandLineRunner atStartup(ProductRepository repository) {
        return args -> {
            repository.saveAll(
                    List.of(new Product("Laptop", 5765.32, "Lenovo workstation", Category.ELECTRONICS),
                            new Product("Pizza", 32.54, "Tasty food", Category.FOODS),
                            new Product("Burger", 25.11, "Tasty food", Category.FOODS),
                            new Product("Football ", 700.02, "Champions League final", Category.LEISURE),
                            new Product("Flight Ticket ", 532.02, "Oradea-London", Category.LEISURE)
                    )

            );

        };
    }

}
