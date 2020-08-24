package ru.igoresha.app.services;

import ru.igoresha.app.forms.ProductForm;
import ru.igoresha.app.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts();
    Product addProduct(ProductForm productForm);

    Product update(Long id, ProductForm productForm);

    Product get(Long id);

    void delete(Long id);

}
