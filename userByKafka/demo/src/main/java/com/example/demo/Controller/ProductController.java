package com.example.demo.Controller;

import com.example.demo.Model.ProductModel;
import com.example.demo.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<ProductModel> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public ProductModel getProductById(@PathVariable String id) {
        return productService.getProductById(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductModel productModel) {
        productService.createProduct(productModel);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }
   @DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
}
