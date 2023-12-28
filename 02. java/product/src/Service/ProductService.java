package Service;

import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import DTO.ProductDTO;
import Main.ProductType;
import Model.*;

public class ProductService {
    private List<Product> productList;

    public ProductService(List<Product> productList) {
        this.productList = productList;
    }

    public void addProduct(ProductDTO productDTO) {
        try {
            ProductType type = productDTO.getType();
            if (type == null) {
                throw new IllegalArgumentException("존재하지 않는 카테고리입니다.");
            }

            Product newProduct = null;
            switch (type) {
                case CLOTHING:
                    newProduct = new Clothing(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity(), productDTO.getSize());
                    break;
                case APPLIANCE:
                    newProduct = new Appliance(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity(), productDTO.getBrand());
                    break;
                case FOOD:
                    newProduct = new Food(productDTO.getName(), productDTO.getPrice(), productDTO.getQuantity(), productDTO.getExpirationDate());
                    break;
            }

            productList.add(newProduct);
            System.out.println("< 상품이 추가되었습니다 >");
            System.out.println();
        } catch (NumberFormatException e) {
            System.out.println("! 유효한 숫자를 입력하세요 !");
            System.out.println();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteProduct(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                productList.remove(product);
                System.out.println("< 상품 정보가 삭제되었습니다 >");
                System.out.println();
                return;
            }
        }

        System.out.println("! 입력하신 상품명의 검색결과가 없습니다 !");
        System.out.println();
    }

 // ProductService.java
    public void modifyProduct(String productName, ProductDTO modifiedProductDTO) {
        Iterator<Product> iterator = productList.iterator();

        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                // 수정 전의 정보를 출력
                printProductInfo(product);
                System.out.println();

                // 수정하기
                product.setName(modifiedProductDTO.getName());
                product.setPrice(modifiedProductDTO.getPrice());
                product.setQuantity(modifiedProductDTO.getQuantity());

                System.out.println("< 상품 정보가 수정되었습니다 >");

                // 수정 후의 정보를 출력
                printProductInfo(product);
                System.out.println();

                return;
            }
        }

        // 상품이 없는 경우
        System.out.println("! 입력하신 상품명의 검색결과가 없습니다 !");
        System.out.println();
    }
    
    public void displayAllProducts() {
    	if(productList.isEmpty()) {
    		System.out.println("! 등록된 상품이 없습니다 !");
    		System.out.println();
    	}
    	else {
    		for (Product product : productList) {
    			printProductInfo(product);
    		}
    	}
    }

    public boolean searchProduct(String productName) { // boolean 타입으로 변경
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                printProductInfo(product);
                System.out.println("< 검색 완료 >");
                System.out.println();
                return true;
            }
        System.out.println("! 입력하신 상품명과 일치하는 상품이 없습니다 !");
        System.out.println();
        } return false;
    }

    private void printProductInfo(Product product) {
        System.out.println("===== 상품 정보 =====");
        System.out.println("상품 분류 : " + product.getType());
        System.out.println("상품명 : " + product.getName());
        System.out.println("상품 가격 : " + (int)(product.getPrice()) + "원");
        System.out.println("상품 수량 : " + product.getQuantity() + "개");
        
        if (product instanceof Clothing) {
            System.out.println("사이즈 : " + ((Clothing) product).getSize());
            System.out.println();
        }
        else if (product instanceof Appliance) {
            System.out.println("브랜드 : " + ((Appliance) product).getBrand());
            System.out.println();
        }
        else if (product instanceof Food) {
        	System.out.println("유통기한 : " + ((Food) product).getExpirationDate());
        	System.out.println();
        }
    }
    
    public void checkExp(String productName) {
    	String[] expDateArray = LocalDate.now().toString().split("-");
    	String expDate = String.join("", expDateArray);
    	int odd = 0;
    	Food foodProduct = null;
    	
    	for (Product product : productList) {
            if (product.getName().equals(productName)) {
            	foodProduct = (Food)product;
            }
    	}
            	int oddYears = Integer.parseInt(foodProduct.getExpirationDate().substring(0, 4)) 
            				- Integer.parseInt(expDate.substring(0, 4));
            	int oddMonths =  Integer.parseInt(foodProduct.getExpirationDate().substring(4, 6)) 
            				- Integer.parseInt(expDate.substring(4, 6));
            	int oddDays = Integer.parseInt(foodProduct.getExpirationDate().substring(6)) 
            				- Integer.parseInt(expDate.substring(6));
            	 
            	odd = oddYears*365 + oddMonths*30 + oddDays;
            	
            	if(Integer.parseInt(foodProduct.getExpirationDate()) < Integer.parseInt(expDate)) {
            		odd = Math.abs(odd);
            		System.out.println("해당 식료품의 유통기한은 " + odd + "일이 지났습니다.");
            	} else if(Integer.parseInt(foodProduct.getExpirationDate()) >= Integer.parseInt(expDate)) {
            		System.out.println("해당 식료품의 유통기한은 " + odd + "일이 남았습니다.");
            	} 
                System.out.println();
    }
}