package Model;

import Main.ProductType;

public class Clothing extends Product {
    private String size;

    public Clothing(String name, double price, int quantity, String size) {
        super(name, price, quantity, ProductType.CLOTHING);
        this.size = size;
    }

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}
}
