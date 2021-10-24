package ru.igoresha.app.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igoresha.app.models.Product;
import ru.igoresha.app.repositories.ProductsRepository;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public List<Product> getAllProducts() {
        return productsRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        productsRepository.save(product);
    }
}
