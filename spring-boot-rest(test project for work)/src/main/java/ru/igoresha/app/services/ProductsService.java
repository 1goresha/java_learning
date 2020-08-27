package ru.igoresha.app.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.igoresha.app.forms.ProductForm;
import ru.igoresha.app.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> getAllProducts();
    Product addProduct(ProductForm productForm);

    Product update(Long id, ProductForm productForm);

    Product get(Long id);

    void delete(Long id);

    Page<Product> getAllProductsPages(Pageable pageable);

    Page<Product> getAllBy(String value, Pageable pageable);

    Page<Product> getAllProductsPagesBySortAndFilter(String sort, String filter, Pageable pageable);
}
