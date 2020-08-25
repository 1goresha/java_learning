package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.forms.ProductForm;
import ru.igoresha.app.models.Product;
import ru.igoresha.app.repositories.ProductsRepository;
import ru.igoresha.app.services.ProductsService;

import java.util.List;

@RestController// тут уже стоит по умолчанию @ResponseBody
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<Page<Product>> getAll(@RequestParam(value = "page", required = false) Integer page,
                                                @RequestParam(value = "size", required = false) Integer size,
                                                @RequestParam(value = "sort", required = false) String sort,
                                                Pageable pageable){
        Page<Product> products = productsService.getAllProductsPages(pageable);
        return ResponseEntity.ok(products);
    }

    @PostMapping
    public ResponseEntity<Product> add(@RequestBody ProductForm productForm){
        return ResponseEntity.status(201).body(productsService.addProduct(productForm));
    }

    @PostMapping("/{product-id}")
    public ResponseEntity<Product> update(@PathVariable(value = "product-id") Long id, @RequestBody ProductForm productForm){
        return ResponseEntity.status(202).body(productsService.update(id, productForm));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<Product> get(@PathVariable(value = "product-id") Long id){
        return ResponseEntity.ok(productsService.get(id));
    }

    @DeleteMapping("/{product-id}")
    public ResponseEntity<Product> delete(@PathVariable(value = "product-id") Long id){
        productsService.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{name}")
    public ResponseEntity<Page<Product>> getAllBy(@PathVariable(value = "name") String name){
        productsService.getAllBy(name);
    }
}
