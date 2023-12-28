package Model;

import Main.ProductType;

public class Appliance extends Product {
    private String brand;

    public Appliance(String name, double price, int quantity, String brand) {
        super(name, price, quantity, ProductType.APPLIANCE);
        this.brand = brand;
    }

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
}
