package step01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
	
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/multi/00.sw/lib/chromedriver.exe";
	
	public static void main(String[] args) {
		
		// 드라이버 설정
		System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
		
		// WebDriver
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.naver.com");
		
		// WebElement
		WebElement input = driver.findElement(By.id("query"));
		
//		System.out.println(input);
		input.sendKeys("crawling");
		input.submit();
		
		driver.navigate().back();
		
		
		input = driver.findElement(By.id("query"));
		
		input.sendKeys("2024년");
		input.submit();
		
		
		
		
		
		

		
		
		
		
		
	}

}