package step04;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import model.domain.Person;

class Product {
	String name;
	int price;
	int productCode;
	public Product(String name, int price, int productCode) {
		super();
		this.name = name;
		this.price = price;
		this.productCode = productCode;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", productCode=" + productCode + "]";
	}
}

public class StreamReview2 {
	public static void main(String[] args) {
		List<Product> productList = Arrays.asList(new Product("potato", 18, 101),
												  new Product("coke", 20, 102), new Product("granola", 55, 103),
												  new Product("orange", 18, 104), new Product("melon", 32, 105));
		
		
		
		// 1. 물건의 이름만 가지고 있는 list를 반환하기 List<String>
		// map, collect
		
		List<String> nameList = productList.stream()
											.map(product -> product.getName())
											.collect(Collectors.toList());
		
		
		System.out.println(
				// v1
//				productList.stream()
//							.map(product -> product.getName())
//							.collect(Collectors.toList())
				
				// v2
//				productList.stream()
//							.map(Product::getName)
//							.collect(Collectors.toList())
		);
		
		
		// 2. 물건의 가격 최종 합
		// price, -> sum()
		int sumPrice = productList.stream()
									.mapToInt(Product::getPrice)
									.sum();
		
		System.out.println(
//				productList.stream()
//							.mapToInt(Product::getPrice)
//							.sum()
		);
		
		
		// 3. 물건 코드별로 그룹화 
		Map<Integer, List<Product>> groupValue = productList.stream()
															.collect(Collectors.groupingBy(Product::getProductCode));
		System.out.println(
				productList.stream()
							.collect(Collectors.groupingBy(Product::getProductCode))
		);
		

							
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}