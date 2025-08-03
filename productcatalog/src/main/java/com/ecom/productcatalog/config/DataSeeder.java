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
        phone.setName("Pixel 8 Pro");
        phone.setDescription("Google Pixel 8 Pro Android smartphone. Announced Oct 2023. Features 6.7″ display, Google Tensor G3 chipset, 5050 mAh battery, 1024 GB storage, 12 GB RAM");
        phone.setImageUrl("https://fs.npstatic.com/devices/77/3477-w320h320.png");
        phone.setPrice(699.99);
        phone.setCategory(electronics);

        Product laptop = new Product();
        laptop.setName("HP Laptop");
        laptop.setDescription("HP 15 - Intel® Core™ 5 – 8GB/ 512 SSD · LKR 229,990 ; HP 15 - Intel® Core™ 3 – 8GB/ 512 SSD · LKR 175,990 ; HP Pavilion x360 Laptop – 14th Gen Core 7-150U/ 16GB RAM");
        laptop.setImageUrl("https://media.istockphoto.com/id/479520746/photo/laptop-with-blank-screen-on-white.jpg?s=612x612&w=0&k=20&c=V5dj0ayS8He0BP4x15WR5t5NKYzWTKv7VdWvD2SAVAM=");
        laptop.setPrice(999.99);
        laptop.setCategory(electronics);

        Product jacket = new Product();
        jacket.setName("Winter Jacket");
        jacket.setDescription("Our exclusive Winter Jacket Collection offers durable, comfortable coats to keep you cozy all season long. Find your perfect parka, down jacket or wool coat");
        jacket.setImageUrl("https://media.istockphoto.com/id/182188051/photo/a-light-blue-winter-jacket-with-hood.jpg?s=612x612&w=0&k=20&c=ywUbJ6kRzppHfXgytC0_mBjWJmchtfKCNeKrSAOCJ10=");
        jacket.setPrice(299.99);
        jacket.setCategory(clothing);

        Product iphone = new Product();
        iphone.setName("Apple 15 Pro max");
        iphone.setDescription("pple iPhone 15 Pro Max smartphone. Announced Sep 2023. Features 6.7″ display, Apple A17 Pro chipset, 4441 mAh battery, 1024 GB storage, 8 GB RAM");
        iphone.setImageUrl("https://smartmobile.lk/image/cache/catalog/Apple%20iPhone%2015%20Pro%20Max-500x500.jpg");
        iphone.setPrice(1499.00);
        iphone.setCategory(electronics);

        Product bat = new Product();
        bat.setName("SF Cricket Bats");
        bat.setDescription("pple iPhone 15 Pro Max smartphone. Announced Sep 2023. Features 6.7″ display, Apple A17 Pro chipset, 4441 mAh battery, 1024 GB storage, 8 GB RAM");
        bat.setImageUrl("https://smartmobile.lk/image/cache/catalog/Apple%20iPhone%2015%20Pro%20Max-500x500.jpg");
        bat.setPrice(1500.00);
        bat.setCategory(electronics);

        productRepository.saveAll(Arrays.asList(phone, laptop, jacket, iphone, bat));
    }
}
