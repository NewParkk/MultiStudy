package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dept.dto.Dept;
import utill.DBUtill;

public class DeptDAO {
	
	// 모든 부서 출력
	public static ArrayList<Dept> getAllDept() throws SQLException, ClassNotFoundException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Dept> deptList = null;
		
		
		
		
		
		try {
			// 1단계 드라이버연결
//			Class.forName("com.mysql.cj.jdbc.Driver");
			// 2단계 db링크 연결
//			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
			conn = DBUtill.getConnection();
			// 3단계 stmt 만들고
			stmt = conn.createStatement();
			// 4단계 쿼리문 날릴 변수
			rset = stmt.executeQuery("SELECT * FROM dept");
			
			// 5단계
			deptList = new ArrayList<Dept>();
			
			while(rset.next()) {
				deptList.add(new Dept(rset.getInt("deptno"), 
										rset.getString("dname"),
										rset.getString("loc")));
			}
			// 6단계
		} finally {
			DBUtill.close(rset, stmt, conn);
			
		}
		return deptList;
	}

		
		
		
	// 특정 부서 출력
		public static Dept getDeptByDeptno(int deptno) throws ClassNotFoundException, SQLException {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rset = null;
			Dept dept = null;
			
			
			try {
				// 1단계 
//				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2단계
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
				conn = DBUtill.getConnection();
				// 3단계 
				stmt = conn.createStatement();
				// 4단계
				rset = stmt.executeQuery("SELECT * FROM dept WHERE deptno = " + deptno);
				
				// 5단계
				while(rset.next()) {
					dept = new Dept(rset.getInt("deptno"), 
									rset.getString("dname"), 
									rset.getString("loc"));
				}
				// 6단계
			} finally {
//				rset.close();
//				stmt.close();
//				conn.close();
				DBUtill.close(rset, stmt, conn);
			}
			
			return dept;
		}
		
		
		
		
		
		// 특정 부서 생성 : INSERT INTO dept VALUES (deptno, dname, loc);
		public static boolean intsertDept(Dept newDept) throws SQLException, ClassNotFoundException {
			Connection conn = null;
//			Statement stmt = null;
			PreparedStatement pstmt = null;
			
			
			
			try {
				// 1단계 
//				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2단계
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
				conn = DBUtill.getConnection();
				// 3단계 
				pstmt = conn.prepareStatement("INSERT INTO dept VALUES (?, ?, ?)");
				// 4단계
//				int result = pstmt.executeUpdate("INSERT INTO dept VALUES(" + newDept.getDeptno()  + " , "
//																		   + newDept.getDname() + "  , "
//																		   + newDept.getLoc() +  ")");
				pstmt.setInt(1, newDept.getDeptno());
				pstmt.setString(2, newDept.getDname());				
				pstmt.setString(3, newDept.getLoc());				
				
				int result = pstmt.executeUpdate();
				
				// 5단계
				if(result != 0) {
					return true;
				}
				// 6단계
			} finally {
				DBUtill.close(pstmt, conn);
//				pstmt.close();
//				conn.close();
			}
			
			return false;
		}
		
		
		public static boolean updateLoc(int deptno, String newLoc) throws SQLException, ClassNotFoundException {
			Connection conn = null;
//			Statement stmt = null;
			PreparedStatement pstmt = null;
			
			    
		    try {
		    	// 1단계 
//				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2단계
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
		    	conn = DBUtill.getConnection();
		        // 3단계
		        pstmt = conn.prepareStatement("UPDATE dept SET loc = ? WHERE deptno = ?");
		        pstmt.setString(1, newLoc);
		        pstmt.setInt(2, deptno);
		        
		        int result = pstmt.executeUpdate();
		        
		        
		        // 5단계
		        if(result != 0) {
					return true;
				}
		        
		        // 6단계 
		    } finally {
		    	DBUtill.close(pstmt, conn);
//		        pstmt.close();
//		        conn.close();
		    }
		    return false;
		}
		
		
		
		
		public static boolean deleteDept(int deptno) throws SQLException, ClassNotFoundException {
			Connection conn = null;
//			Statement stmt = null;
			PreparedStatement pstmt = null;
			
			    
		    try {
		    	// 1단계 
//				Class.forName("com.mysql.cj.jdbc.Driver");
				// 2단계
//				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/SCOTT?serverTimezone=Asia/Seoul", "SCOTT", "TIGER");
				conn = DBUtill.getConnection();
		        // 3단계
		        pstmt = conn.prepareStatement("DELETE FROM dept WHERE deptno = ? ");
		        pstmt.setInt(1, deptno);
		        
		        int result = pstmt.executeUpdate();
		        
		        // 5단계
		        if(result != 0) {
					return true;
				}
		        
		        // 6단계 
		    } finally {
		    	DBUtill.close(pstmt, conn);
//		        pstmt.close();
//		        conn.close();
		    }
		    return false;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
}