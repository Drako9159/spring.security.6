package drako.springsecurity.controller;

import drako.springsecurity.entity.Product;
import drako.springsecurity.repository.IProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductRepository iProductRepository;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> products = iProductRepository.findAll();
        if (products != null && !products.isEmpty()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Product> createOne(@RequestBody @Valid Product product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(iProductRepository.save(product));
    }

}
