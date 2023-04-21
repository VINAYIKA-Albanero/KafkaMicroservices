package com.example.demo.Services;

import com.example.demo.Model.ProductModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    private List<ProductModel> products = new ArrayList<ProductModel>(Arrays.asList());

    public List<ProductModel> getAllProducts() {
        return products;
    }

    public ProductModel getProductById(String id) {
        return products.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createProduct(ProductModel productModel) {
        products.add(productModel);
    }

    public void updateProduct(String id, ProductModel productModel) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(id)) {
                products.set(i, productModel);
                break;
            }
        }
    }

    public void deleteProduct(String id) {
        products.removeIf(product -> product.getId().equals(id));
    }
}
