package com.geek.lesson3homework.controllers;

import com.geek.lesson3homework.Exceptions.NoSuchProductException;
import com.geek.lesson3homework.model.Product;
import com.geek.lesson3homework.repository.InMemoryProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final InMemoryProductRepository repository;

    public ProductController(InMemoryProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public String showAll(Model model) throws NoSuchProductException {
        model.addAttribute("products", repository.getAllProducts());
        return "products.html";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model){
        try {
            model.addAttribute("product", repository.getProduct((long) id));
        } catch (NoSuchProductException e) {
            model.addAttribute("error", e);
            return "error.html";
        }
        return "singleProduct.html";
    }

    @GetMapping("/add")
    public String callProductForm(Model model){
        model.addAttribute("product", new Product());
        return "addProduct.html";
    }


    @PostMapping("/add")
    public String submitProduct(@ModelAttribute Product product){
        System.out.println("added");
        repository.addProduct(product);
        System.out.println(product);
        return "redirect:/products";
    }
}
