package step01;

import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupTest {

	public static ArrayList Titlesget() {
		ArrayList<String> getTitles = new ArrayList<>();
		Document sports_doc = null;
		try {
			sports_doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements titles = sports_doc.select("#content > div > div.home_grid > div.content > div.home_article > div.home_news > ul > li > a");
		
		for(Element title : titles) {
			getTitles.add(title.text());
		}
		
		return getTitles;
	}
	
	
	public static ArrayList Linksget() {
		ArrayList<String> getLinks = new ArrayList<>();
		Document sports_doc = null;
		try {
			sports_doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Elements titles = sports_doc.select("#content > div > div.home_grid > div.content > div.home_article > div.home_news > ul > li > a");
		
		for(Element title : titles) {
			getLinks.add(title.absUrl("href"));
		}
		
		return getLinks;
	}
	
	
	
	
	public static void main(String[] args) {
		
		try {
			Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
			// Elemet, Elements
//			System.out.println(doc.getElementById("mp-welcome"));
//			System.out.println(doc.select("#mp-welcome"));
//			System.out.println(doc.select("#mp-itn > ul > li:nth-child(1) > b > a").get(0).absUrl("href"));
//			System.out.println(doc.getElementById("mp-itn").getElementsByTag("b"));
			
//			System.out.println(doc.select("#mp-itn > ul > li:nth-child(2) > b > a").get(0).absUrl("href"));
//			Elements news = doc.select("#mp-itn > ul > li > b > a");
//			for(Element title : news) {
//				System.out.println(title.absUrl("href"));
//			}
//			
//			
//			Elements On_this_day = doc.select("#mp-otd > ul > li > b > a");
//			for(Element title : On_this_day) {
//				System.out.println(title.absUrl("href"));
//			}
			
			
//			Document doc2 = Jsoup.connect("https://www.w3schools.com/java/default.asp").get();
//			
//			Elements titles = doc2.select("#main > h2");
//			
//			for(Element title : titles) {
//				System.out.println(title.text());
//			}
			
			
//		
//			news(table)
//			title (varchar) :
//			url (text) : 
			
//			doc = Jsoup.connect("https://www.w3schools.com/java/default.asp").get();
//			Elements titles = doc.select("#main > h2");
//			Elements titles = doc.selectXpath("//*[@id=\"main\"]/h2");
//			for(Element title : titles) {
//				System.out.println(title.text());
//			}
			
			
			
			
//			Test	
			System.out.println(JsoupTest.Titlesget());
			System.out.println(JsoupTest.Linksget());
		
		
			
			doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
			/*
				.home_news li a
			 */
			
			Elements news = doc.select(".home_news li a");
			for(Element article : news) {
				System.out.println(article.text());
				System.out.println(article.absUrl("href"));
				
				System.out.println();
			}
			
			
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	
		
	}
}
