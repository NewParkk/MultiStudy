package Main;

import Contorller.Controller;
import Database.Database;
import Service.ProductService;
import View.ConsoleView;

public class Main {
    public static void main(String[] args) {
        Database database = new Database();
        ProductService productService = new ProductService(database.getProductList());
        ConsoleView consoleView = new ConsoleView();
        Controller controller = new Controller(productService, consoleView);
        controller.run();
    }
}