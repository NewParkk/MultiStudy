package View;

import java.util.Scanner;

import DTO.ProductDTO;
import Main.ProductType;

public class ConsoleView {
    private Scanner scanner;

    public ConsoleView() {
        this.scanner = new Scanner(System.in);
    }

    public int showMenu() {
    	int choice;
        while (true) {
            try {
                System.out.println("======= 메뉴 =======");
                System.out.println("1. 상품 등록");
                System.out.println("2. 상품 정보 삭제");
                System.out.println("3. 상품 정보 수정");
                System.out.println("4. 등록된 상품들 확인");
                System.out.println("5. 상품 검색");
                System.out.println("6. 식료품의 유통기한 확인");
                System.out.println("7. 프로그램 종료");
                System.out.println();
                System.out.print(">> 메뉴를 선택해주세요 : ");
                choice = Integer.parseInt(scanner.next());
                System.out.println();
                if (choice < 1 || choice > 7) {
                    throw new IllegalArgumentException("! 메뉴 번호는 1부터 7까지 입력하세요 !");
                }
                break; // 정상 입력이면 반복문 탈출
            } catch (NumberFormatException e) {
                System.out.println("! 숫자를 입력하세요 !");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return choice;
    }

    public ProductDTO getProductInfo(boolean askForCategory) {
        String name;
        double price;
        int quantity;

        ProductType type = null;
        String additionalInfo = "";

        while (true) {
            try {
                System.out.print(">> 상품명 : ");
                name = scanner.next();
                if (name == null || name.trim().isEmpty()) {
                    throw new IllegalArgumentException("! 상품명을 입력하세요 !");
                }
                scanner.nextLine();

                System.out.print(">> 가격 : ");
                price = Double.parseDouble(scanner.next());

                System.out.print(">> 수량 : ");
                quantity = Integer.parseInt(scanner.next());
                System.out.println();

                if (askForCategory) {
                    System.out.println("< 상품 카테고리를 선택하세요 >");
                    System.out.println("1. 의류");
                    System.out.println("2. 전자제품");
                    System.out.println("3. 식품");
                    System.out.println();
                    System.out.print(">> 카테고리 번호 입력 : ");
                    int typeChoice = Integer.parseInt(scanner.next());
                    System.out.println();
                    type = ProductType.getByCode(typeChoice);

                    if (type != null) {
                        switch (type) {
                            case CLOTHING:
                                System.out.print(">> 사이즈 : ");
                                additionalInfo = scanner.next();
                                break;
                            case APPLIANCE:
                                System.out.print(">> 브랜드 : ");
                                additionalInfo = scanner.next();
                                break;
                            case FOOD:
                                System.out.print(">> 유통기한 : ");
                                additionalInfo = scanner.next();
                                break;
                            default:
                                throw new IllegalArgumentException("! 존재하지 않는 카테고리입니다 !");
                        }
                    }
                }

                // 변경된 부분 : 조건에 따라 생성자를 호출, 기본 값들은 그냥 반환하고 if문 실행돼서 추가 정보를 받았을 경우에만 추가 정보 반환
                return new ProductDTO(name, price, quantity, type, 
                        (type != null && type == ProductType.CLOTHING) ? additionalInfo : null,
                        (type != null && type == ProductType.APPLIANCE) ? additionalInfo : null,
                        (type != null && type == ProductType.FOOD) ? additionalInfo : null);
            } catch (NumberFormatException e) {
                System.out.println("! 유효한 숫자를 입력하세요 !");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String getProductName() {
        System.out.print("상품명 입력 : ");
        return scanner.next();
    }

    public void closeScanner() {
        scanner.close();
    }
}
