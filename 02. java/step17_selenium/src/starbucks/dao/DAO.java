package starbucks.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;


public class DAO {
//	public static boolean intsertData() throws SQLException{
//		Connection conn = null;
//		PreparedStatement pstmt = null;
//		
//		try {
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
//			pstmt = conn.prepareStatement("INSERT INTO starbucks VALUES (?, ?, ?, ?, ?, ?, ?)");
//			
//			
//		
//			for (int i=0; i < titles.size(); i++) {
//				
//				pstmt.setString(1, );
//				pstmt.setString(2, );
//				pstmt.setString(3, );
//				pstmt.setString(4, );
//				pstmt.setString(5, );
//				pstmt.setString(6, );
//				pstmt.setString(7, );
//
//				pstmt.executeUpdate();
//			}
//
//			
//			int result = pstmt.executeUpdate();
//			
//			// 5단계
//			if(result != 0) {
//				return true;
//			}
//			// 6단계
//		} finally {
//			
//			if (pstmt != null) {
//		        pstmt.close();
//		        }
//	        if (conn != null) {
//	            conn.close();
//	        }
//		}
//		
//		return false;
//	}
}
