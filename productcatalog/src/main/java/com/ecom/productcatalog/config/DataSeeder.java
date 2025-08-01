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
        phone.setImageUrl("https://fs.npstatic.com/devices/77/3477-w320h320.png");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("Laptop");
        laptop.setDescription("High-performance Laptop");
        laptop.setImageUrl("https://media.istockphoto.com/id/479520746/photo/laptop-with-blank-screen-on-white.jpg?s=612x612&w=0&k=20&c=V5dj0ayS8He0BP4x15WR5t5NKYzWTKv7VdWvD2SAVAM=");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Warm jacket");
        jacket.setImageUrl("https://media.istockphoto.com/id/182188051/photo/a-light-blue-winter-jacket-with-hood.jpg?s=612x612&w=0&k=20&c=ywUbJ6kRzppHfXgytC0_mBjWJmchtfKCNeKrSAOCJ10=");
        jacket.setPrice(299.99);
        jacket.setCategory(clothing);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket));
    }
}
