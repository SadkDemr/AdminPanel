package com.adminpanel.service;

import com.adminpanel.entity.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService1 {
    List<Product> getAllProducts();

    Product saveProduct(MultipartFile file, String productName,
                        String brandName, String properties);

    Product getProductById(Long id);

    Product updateProduct(Product product);

    void deleteProductById(Long id);

}
