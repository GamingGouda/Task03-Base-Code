package com.scalable.task03.config;

import com.scalable.task03.model.Product;
import com.scalable.task03.model.ProductCategory;
import com.scalable.task03.model.Role;
import com.scalable.task03.model.User;
import com.scalable.task03.repository.ProductRepository;
import com.scalable.task03.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DataSeeder {

    private final UserRepository userRepository;
    private final ProductRepository productRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DataSeeder(UserRepository userRepository, ProductRepository productRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.productRepository = productRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Seeds the admin account if it does not already exist.
     * @return true if a new admin account was created, false if it already existed
     */
    public boolean seedAdminAccount() {
        String adminEmail = "admin@guc.edu.eg";
        if (userRepository.existsByEmail(adminEmail)) {
            return false;
        }
        User admin = new User(
                "Admin",
                adminEmail,
                passwordEncoder.encode("admin123"),
                Role.ADMIN
        );
        userRepository.save(admin);
        return true;
    }

    /**
     * Seeds 8 sample products spanning all 4 categories if the products table is empty.
     * @return true if products were seeded, false if the table was already non-empty
     */
    public boolean seedSampleProducts() {
        if (productRepository.count() > 0) {
            return false;
        }
        List<Product> samples = List.of(
                new Product("Wireless Headphones", "Over-ear Bluetooth headphones with noise cancellation", new BigDecimal("79.99"), ProductCategory.ELECTRONICS, 50),
                new Product("USB-C Hub", "7-in-1 USB-C hub with HDMI, SD card, and three USB ports", new BigDecimal("34.99"), ProductCategory.ELECTRONICS, 100),
                new Product("Cotton T-Shirt", "Plain cotton crew-neck t-shirt", new BigDecimal("19.99"), ProductCategory.CLOTHING, 200),
                new Product("Denim Jeans", "Slim-fit denim jeans, dark wash", new BigDecimal("49.99"), ProductCategory.CLOTHING, 75),
                new Product("Dark Chocolate Bar", "70% cocoa dark chocolate, 100g", new BigDecimal("4.99"), ProductCategory.FOOD, 300),
                new Product("Olive Oil 500ml", "Extra virgin olive oil, cold-pressed", new BigDecimal("12.99"), ProductCategory.FOOD, 80),
                new Product("Clean Code", "A handbook of agile software craftsmanship by Robert C. Martin", new BigDecimal("32.99"), ProductCategory.BOOKS, 40),
                new Product("The Pragmatic Programmer", "Your journey to mastery, by Hunt and Thomas", new BigDecimal("39.99"), ProductCategory.BOOKS, 35)
        );
        productRepository.saveAll(samples);
        return true;
    }
}
