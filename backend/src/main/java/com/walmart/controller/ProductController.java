package com.walmart.controller;
import com.walmart.model.Product;
import com.walmart.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductRepository repo;
    public ProductController(ProductRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Product> getAll() { return repo.findAll(); }

    @PostMapping
    public Product addProduct(@RequestBody Product p) { return repo.save(p); }
}
