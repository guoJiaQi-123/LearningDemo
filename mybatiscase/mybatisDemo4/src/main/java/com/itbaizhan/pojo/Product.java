package com.itbaizhan.pojo;

public class Product {
    private Integer id;

    private String productname;

    private Double price;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productname='" + productname + '\'' +
                ", price=" + price +
                '}';
    }

    public Product() {
    }

    public Product(String productname, Double price) {
        this.productname = productname;
        this.price = price;
    }

    public Product(Integer id, String productname, Double price) {
        this.id = id;
        this.productname = productname;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}