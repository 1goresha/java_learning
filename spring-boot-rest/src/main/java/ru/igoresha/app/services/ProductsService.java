package ru.igoresha.app.services;

import ru.igoresha.app.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts();
    void addProduct(Product product);
}
