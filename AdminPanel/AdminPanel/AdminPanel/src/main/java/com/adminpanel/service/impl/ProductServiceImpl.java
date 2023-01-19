package com.adminpanel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import com.adminpanel.entity.Product;
import com.adminpanel.repository.ProductRepository;
import com.adminpanel.service.ProductService1;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService1 {

    @Autowired
    private ProductRepository productRepository;
    public ProductServiceImpl(ProductRepository productRepository){
        super();
        this.productRepository = productRepository;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(MultipartFile file,String productName,
                               String brandName,String properties) {
        Product product = new Product();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            product.setImageUrl(Base64.getEncoder().encodeToString(file.getBytes()));
        }catch (IOException e){
            e.printStackTrace();
        }
        product.setProperties(properties);
        product.setProductName(productName);
        product.setBrandName(brandName);

        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).get();
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProductById(Long id) {
        productRepository.deleteById(id);

    }
}
