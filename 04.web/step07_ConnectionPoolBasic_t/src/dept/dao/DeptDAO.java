package dept.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBUtil;

public class DeptDAO {
	
	// Query : SELECT dname FROM dept WHERE deptno = ?
	public static String getDeptDnameByDeptno(int deptno) throws SQLException {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		String dname = null;
		String sql = "SELECT dname FROM dept WHERE deptno = ?";
		try {
			con = DBUtil.getConnection();
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, deptno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				dname = rset.getString("dname");
			}
		} finally {
			rset.close();
			pstmt.close();
			con.close();
		}
		return dname;
	}

}


