package Contorller;

import DTO.ProductDTO;
import Service.ProductService;
import View.ConsoleView;

public class Controller {
    private ProductService productService;
    private ConsoleView consoleView;

    public Controller(ProductService productService, ConsoleView consoleView) {
        this.productService = productService;
        this.consoleView = consoleView;
    }

    public void run() {
    	while (true) {
            int choice = consoleView.showMenu();

            switch (choice) {
                case 1:
                    ProductDTO productDTO = consoleView.getProductInfo(true);
                    productService.addProduct(productDTO);
                    break;
                case 2:
                    String deleteProductName = consoleView.getProductName();
                    productService.deleteProduct(deleteProductName);
                    break;
                case 3:
                	String modifyProductName = consoleView.getProductName();
                    if (productService.searchProduct(modifyProductName) == true) { 
                    	ProductDTO modifiedProductDTO = consoleView.getProductInfo(false);
                   	 	productService.modifyProduct(modifyProductName, modifiedProductDTO);
                    }
                    System.out.println("! 입력하신 상품명과 일치하는 상품이 없습니다 !");
                    break;
                case 4:
                    productService.displayAllProducts();
                    break;
                case 5:
                    String searchProductName = consoleView.getProductName();
                    productService.searchProduct(searchProductName);
                    break;
                case 6:
                	String foodProductName = consoleView.getProductName();
                	productService.checkExp(foodProductName);
                	break;
                case 7:
                    consoleView.closeScanner();
                    System.out.println("<< 프로그램을 종료합니다 >>");
                    System.exit(0);
                    break;
                default:
                    System.out.println("! 유효한 메뉴를 선택하세요 !");
            }
        }
    }
}
