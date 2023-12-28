package Model;

import Main.ProductType;

public class Food extends Product {
    private String expirationDate;

    public Food(String name, double price, int quantity, String expirationDate) {
        super(name, price, quantity, ProductType.FOOD);
        this.expirationDate = expirationDate;
    }

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}
}
