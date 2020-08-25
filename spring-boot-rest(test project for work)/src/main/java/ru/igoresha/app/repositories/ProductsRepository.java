package ru.igoresha.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.Product;


public interface ProductsRepository extends JpaRepository<Product, Long> {
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByName(String name, Pageable pageable);
    Page<Product> findFirstByPrice(Double price, Pageable pageable);
    Page<Product> findAllByNameContains(String name, Pageable pageable);

}
