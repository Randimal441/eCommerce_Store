package com.ecom.productcatalog.config;

import com.ecom.productcatalog.model.Category;
import com.ecom.productcatalog.model.Product;
import com.ecom.productcatalog.repository.CategoryRepository;
import com.ecom.productcatalog.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public DataSeeder(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Clear all existing data
        productRepository.deleteAll();
        categoryRepository.deleteAll();

        //creat category
        Category electronics = new Category();
        electronics.setName("Electronics");

        Category clothing = new Category();
        clothing.setName("Clothing");

        Category home = new Category();
        home.setName("Home and Kitchen");

        categoryRepository.saveAll(Arrays.asList(electronics, home, clothing));

        //creat category
        Product phone = new Product();
        phone.setName("Smart Phone");
        phone.setDescription("Letest model");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        phone.setName("Laptop");
        phone.setDescription("High-performance Laptop");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(999.99);
        phone.setCategory(electronics);

        Product jacket = new Product();
        phone.setName("Winter Jacket");
        phone.setDescription("Warm jacket");
        phone.setImageUrl("https://placehold.co/600x400");
        phone.setPrice(299.99);
        phone.setCategory(clothing);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket));
    }
}
