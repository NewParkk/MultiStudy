package Database;

import java.util.ArrayList;
import java.util.List;

import Model.Product;

public class Database {
    private List<Product> productList;

    public Database() {
        this.productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }
}