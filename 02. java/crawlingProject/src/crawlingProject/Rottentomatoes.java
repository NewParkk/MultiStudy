package crawlingProject;

import java.sql.SQLException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import movie.DAO.DAO;

public class Rottentomatoes {
	public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
	public static String WEB_DRIVER_PATH = "C:/multi/00.sw/lib/chromedriver.exe";
	
	
		
		public static void collectData() throws SQLException {	
			// 드라이버 설정
			System.setProperty("webdriver.chrome.driver", WEB_DRIVER_PATH);
			
			// WebDriver
			WebDriver driver = new ChromeDriver();
			
			driver.get("https://www.rottentomatoes.com/");
			WebDriverWait wait = new WebDriverWait(driver, 3);
			
			WebElement movies = driver.findElement(By.cssSelector("#header-main > rt-header-nav > rt-header-nav-item:nth-child(1)"));
			
			movies.click();
			
			
			List <WebElement> infos = driver.findElements(By.cssSelector("#main-page-content > div.discovery > div.discovery-grids-container > div > div > div > div > tile-dynamic > a"));
			
			for (WebElement info : infos) {
				String title = info.findElement(By.cssSelector(".p--small")).getText();
				System.out.println("영화 제목 : "  + title);
				WebElement movie_rate = info.findElement(By.tagName("score-pairs-deprecated"));
				
				String tomato_rate = movie_rate.getAttribute("audiencescore");
			    System.out.println("토마토 평점  : " + tomato_rate);

			    int tomatoRate = 0;
			    if (tomato_rate != null && !tomato_rate.isEmpty() && tomato_rate.matches("\\d+")) {
			        tomatoRate = Integer.parseInt(tomato_rate);
			    }

			    String audience_rate = movie_rate.getAttribute("criticsscore");
			    System.out.println("청중 평점 : " + audience_rate);

			    int audienceRate = 0;
			    if (audience_rate != null && !audience_rate.isEmpty() && audience_rate.matches("\\d+")) {
			        audienceRate = Integer.parseInt(audience_rate);
			    }
				
				String date = info.findElement(By.cssSelector(".smaller")).getText();
				System.out.println("개봉일 : " + date);
				System.out.println("-------------------");
				
				
				boolean success = DAO.insertData(title, tomatoRate, audienceRate, date);
	            if (success) {
	                System.out.println("데이터베이스에 성공적으로 삽입되었습니다.");
	            } else {
	                System.out.println("데이터베이스 삽입에 실패했습니다.");
            }	
		}		
	}			
}				
