package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.forms.ProductForm;
import ru.igoresha.app.models.Product;
import ru.igoresha.app.services.ProductsService;

import java.util.List;

@RestController// тут уже стоит по умолчанию @ResponseBody
@RequestMapping(value = "/products")
public class ProductController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll(){
        List<Product> products = productsService.getAllProducts();
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
}
