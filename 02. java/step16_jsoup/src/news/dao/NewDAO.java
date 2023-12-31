package news.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import step01.JsoupTest;

public class NewDAO {
	
		public static boolean intsertData() throws SQLException{
			Connection conn = null;
			PreparedStatement pstmt = null;
			
			try {
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
				pstmt = conn.prepareStatement("INSERT INTO news VALUES (?, ?)");
				ArrayList<String> titles = JsoupTest.Titlesget();
				ArrayList<String> links = JsoupTest.Linksget();
				
				
				for (int i=0; i < titles.size(); i++) {
					
					pstmt.setString(1, titles.get(i));
					pstmt.setString(2, links.get(i));
					pstmt.executeUpdate();
				}

				
				int result = pstmt.executeUpdate();
				
				// 5단계
				if(result != 0) {
					return true;
				}
				// 6단계
			} finally {
				
				if (pstmt != null) {
			        pstmt.close();
			        }
		        if (conn != null) {
		            conn.close();
		        }
			}
			
			return false;
		}
		
//		이렇게도 가능
//		doc = Jsoup.connect("https://sports.news.naver.com/wfootball/index.nhn").get();
//		
//		Elements news = doc.select(".home_news li a");
//		for(Element article : news) {
//			try {
//				NewsDAO.insertDept(new News(article.text(), article.absUrl("href")));
//			} catch (ClassNotFoundException | SQLException e) {
//				e.printStackTrace();
//			}
//		}	
			
	
}
