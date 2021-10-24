package ru.igoresha.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.igoresha.app.models.Product;

public interface ProductsRepository extends JpaRepository<Product, Long> {
}
