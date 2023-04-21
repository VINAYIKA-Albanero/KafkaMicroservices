package com.example.demo.Services;

import com.example.demo.Model.ProductModel;
import com.example.demo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    public ProductRepo productRepo;
    public List<ProductModel> getAllProducts() {

        return productRepo.findAll();
    }

    public ProductModel getProductById(String id) {
        return productRepo.getProductById(id);
    }
    public void createProduct(ProductModel productModel) {
        productRepo.save(productModel);
    }
    public void deleteProduct(String id) {

        productRepo.deleteById(id);
    }
}
