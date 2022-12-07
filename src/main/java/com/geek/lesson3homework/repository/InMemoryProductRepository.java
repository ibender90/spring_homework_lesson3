package com.geek.lesson3homework.repository;

import com.geek.lesson3homework.Exceptions.NoSuchProductException;
import com.geek.lesson3homework.model.Product;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class InMemoryProductRepository {
    private List<Product> database;

    private static Integer counter;

    @PostConstruct
    private void init() {
        this.database = new ArrayList<>(Arrays.asList(
                new Product(1L, "Dog food", 3D),
                new Product(2L, "Cat food", 2.50D),
                new Product(3L, "Hamster food", 1.20D),
                new Product(4L, "Bird food", 2.20D),
                new Product(5L, "Snake food", 5.0D)
        ));
    }

    public List<Product> getAllProducts() {
        return database;
    }

    public Product getProduct(Long id) throws NoSuchProductException {
        for (Product p :
                database) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new NoSuchProductException();
    }

    public void addProduct(Product product) {
        product.setId(autoincrement());
        database.add(product);
    }

    private Long autoincrement(){ //пока нет базы данных
        if(counter == null){
            counter = database.size() + 1;
        } else {
            counter++;
        }
        return Long.valueOf(counter);
    }
}

