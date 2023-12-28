package DTO;

import Main.ProductType;

public class ProductDTO {
    private String name;
    private double price;
    private int quantity;
    private ProductType type;
    private String size;
    private String brand;
    private String expirationDate;

    public ProductDTO(String name, double price, int quantity, ProductType type, String size, String brand, String expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
        this.size = size;
        this.brand = brand;
        this.expirationDate = expirationDate;
    }

    // 기본 생성자 추가
    public ProductDTO(String name, double price, int quantity) {
        this(name, price, quantity, null, null, null, null);
    }

    public ProductType getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getBrand() {
        return brand;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}