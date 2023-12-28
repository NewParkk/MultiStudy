package step01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StarTest {
	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/multi/00.sw/lib/chromedriver.exe";
	
	public static void main(String[] args) {
		
		// 드라이버 설정
		System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
		
		// WebDriver
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.starbucks.co.kr/menu/drink_list.do");
		
		// 방법
		// 전체 각각의 물품에 접근 -> 클릭 -> 세부데이터
		List<WebElement> productList = driver.findElements(By.cssSelector(".product_list > dl > dd > ul > li"));
//		System.out.println(productList.size());
		
			
			try {
				for(WebElement product : productList) {
					product.click();
					
					Thread.sleep(1000);
					
					// 세부데이터 -> back()
					List<WebElement> infoList = driver.findElements(By.cssSelector(".product_info_content > ul > li"));
					for(WebElement info : infoList) {
						System.out.println(info.findElement(By.tagName("dd")).getText());
					}
					System.out.println("-----");
					driver.navigate().back();
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				
			}
		
	}
}