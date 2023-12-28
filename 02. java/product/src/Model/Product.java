package Model;

import Main.ProductType;

public class Product {
    private String name;
    private double price;
    private int quantity;
    private ProductType type;

    public Product(String name, double price, int quantity, ProductType type) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("상품명을 입력하세요.");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("가격은 0보다 커야 합니다.");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("수량은 0보다 커야 합니다.");
        }
        if (type == null) {
            throw new IllegalArgumentException("상품 타입을 선택하세요.");
        }

        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public ProductType getType() {
        return type;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}