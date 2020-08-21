package ru.igoresha.app.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.igoresha.app.models.Product;
import ru.igoresha.app.services.ProductsService;

import java.util.List;

@Controller
@RequestMapping(value = "/products")
public class ProductsController {

    @Autowired
    private ProductsService productsService;

    @GetMapping
    public String getProducts(ModelMap modelMap) {
        List<Product> products = productsService.getAllProducts();
        modelMap.addAttribute("products", products);
        return "products";
    }

    @PostMapping
    public String addProducts(Product product){// Post форма автоматически сконвертируется в Product объект
        this.productsService.addProduct(product);
        return "redirect:/products";
    }

    @PostMapping("/json")
    @ResponseBody//ответ уйдет в Json формате
    public List<Product> addProductByJson(@RequestBody Product product){  //преобразование из json в объект
        this.productsService.addProduct(product);
        return this.productsService.getAllProducts();
    }


}
