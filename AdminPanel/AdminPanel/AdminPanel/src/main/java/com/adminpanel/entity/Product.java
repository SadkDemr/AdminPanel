package com.adminpanel.entity;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "brand_name")
    private String brandName;

    @Column(name = "properties")
    private String properties;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String imageUrl;

    public Product(){

    }

    public  Product(String productName,String brandName,String properties,String imageUrl){
        super();
        this.productName = productName;
        this.brandName = brandName;
        this.properties = properties;
        this.imageUrl = imageUrl;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getProperties() {
        return properties;
    }

    public void setProperties(String properties) {
        this.properties = properties;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

}
