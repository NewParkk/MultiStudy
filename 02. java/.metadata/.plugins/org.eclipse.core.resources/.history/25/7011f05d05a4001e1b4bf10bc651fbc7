package movie.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import movie.utill.DBUtill;

public class DAO {
		
	public static boolean insertData(String title, Integer tomatoRate, Integer audienceRate, String releaseDate) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt =  null;
//			ResultSet rset = null;
//			Statement stmt = null;
			
		try {
			conn = DBUtill.getConnection();
			pstmt =  conn.prepareStatement("INSERT INTO movie VALUES(?, ?, ?, ?)");
			
			pstmt.setString(1, title);
            pstmt.setInt(2, tomatoRate);
            pstmt.setInt(3, audienceRate);
            pstmt.setString(4, releaseDate);
            
            int result = pstmt.executeUpdate();
            
			
				
				
            if(result != 0) {
				return true;
			}
			// 6단계
		} finally {
			DBUtill.close(pstmt, conn);
//			pstmt.close();
//			conn.close();
		}	
				
		
			return false;
		}


}
