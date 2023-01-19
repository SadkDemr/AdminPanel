package com.adminpanel.controller;

import com.adminpanel.entity.Product;
import com.adminpanel.service.ProductService1;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController1 {
    private ProductService1 productService1;

    public ProductController1(ProductService1 productService1){
        super();
        this.productService1 = productService1;
    }

    @GetMapping("/product/page")
    public String showProducts(Model model){
        model.addAttribute("products",productService1.getAllProducts());
        return "product_page";
    }
    @GetMapping("/products")
    public String listProducts(Model model){
        model.addAttribute("products",productService1.getAllProducts());
        return "products";
    }
    public static String uploadDirectory=System.getProperty("user.dir")+"/src/main/resources/imagedata";

    @GetMapping("/products/new")

    public String createProductForm(Model model) {
        Product product = new Product();

        model.addAttribute("product", product);
        return "create_product";
    }


    @PostMapping("/products")
    public String saveProduct(@RequestParam("file") MultipartFile file,
                              @RequestParam("productName") String productName,
                              @RequestParam("brandName") String brandName,
                              @RequestParam("properties") String properties) {

     productService1.saveProduct(file,productName,brandName,properties);

        return "redirect:/products";

    }

    @GetMapping("/products/edit/{id}")
    public String editProductForm(@PathVariable Long id,Model model){
        model.addAttribute("product",productService1.getProductById(id));
        return "edit_product";
    }

    @PostMapping("/products/{id}")
    public String updateProduct(@PathVariable Long id,
           @ModelAttribute("product") Product product,
           Model model){

        Product existingProduct = productService1.getProductById(id);
        existingProduct.setId(id);
        existingProduct.setProductName(product.getProductName());
        existingProduct.setBrandName(product.getBrandName());
        existingProduct.setProperties(product.getProperties());
        existingProduct.setImageUrl(product.getImageUrl());

        productService1.updateProduct(existingProduct);
        return "redirect:/products";
    }

    @GetMapping("/products/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService1.deleteProductById(id);
        return "redirect:/products";
    }




}
