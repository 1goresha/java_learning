package ru.igoresha.app.services;

import org.hibernate.proxy.HibernateProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.igoresha.app.forms.ProductForm;
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
    public Product addProduct(ProductForm productForm) {
        Product product = Product.builder()
                .name(productForm.getName())
                .price(productForm.getPrice())
                .build();
        productsRepository.save(product);
        return product;
    }

    @Override
    public Product update(Long id, ProductForm productForm) {
        Product product = productsRepository.getOne(id);
        product.setName(productForm.getName());
        product.setPrice(productForm.getPrice());
        return productsRepository.save(product);
    }

    @Override
    public Product get(Long id) {
        Product product =  productsRepository.getOne(id);
        if (product instanceof HibernateProxy){
            return (Product) ((HibernateProxy) product).getHibernateLazyInitializer().getImplementation();
        }
        return product;
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }
}
