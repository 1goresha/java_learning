package ru.igoresha.app.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.igoresha.app.models.Product;


public interface ProductsRepository extends JpaRepository<Product, Long> {
    Page<Product> findByName(String name, Pageable pageable);
    Page<Product> findAll(Pageable pageable);
    Page<Product> findAllByName(String name, Pageable pageable);
    Page<Product> findAllByPriceContainsOrderByPriceAsc(Double price, Pageable pageable);
    Page<Product> findAllByNameContainsOrderByNameAsc(String name, Pageable pageable);

//    Page<Product> findAllByPrice(Double price, Pageable pageable);

    @Query("SELECT p FROM Product p WHERE CONCAT(p.price,'') LIKE %:price%")
    Page<Product> findAllByPrice(@Param("price") String price, Pageable pageable);

}
