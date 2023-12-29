package emp.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.util.DBUtil;
import dept.dto.Dept;
import emp.dto.Emp;

public class EmpDAO {
	// getEmpByEmpnoAndEname
	// Query : SELECT * FROM emp WHERE empno = ? AND ename = ?
	public static Emp getEmpByEmpnoAndEname(int empno, String ename) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Emp emp = null;
		
		String sql = "SELECT * FROM emp WHERE empno = ? AND ename = ?";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
			if(rset.next()) {
				// ?
			}
		}finally {
			DBUtil.close(rset, pstmt, con);
		}
		
		return emp;
	}
}
