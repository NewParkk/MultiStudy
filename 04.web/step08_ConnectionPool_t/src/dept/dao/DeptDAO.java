package dept.dao; 

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import common.util.DBUtil;
import dept.dto.Dept;

public class DeptDAO {
	// getDeptList
	// Query : SELECT * FROM dept;
	public static ArrayList<Dept> getDeptList() throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		ArrayList<Dept> deptList = null;
		
		String sql = "SELECT * FROM dept";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
		}finally {
			DBUtil.close(rset, pstmt, con);
		}
		
		return deptList;
	}
	
	// getDeptByDeptno
	// Query : SELECT * FROM dept WHERE deptno = ?
	public static Dept getDeptByDeptno(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;

		Dept dept = null;
		
		String sql = "SELECT * FROM dept WHERE deptno = ?";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
		}finally {
			DBUtil.close(rset, pstmt, con);
		}
		
		return dept;
	}

	// insertDept
	// Query : INSERT INTO dept(deptno, dname, loc) VALUES (?, ?, ?)
	public static boolean insertDept(Dept dept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql = "INSERT INTO dept(deptno, dname, loc) VALUES (?, ?, ?)";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
		}finally {
			DBUtil.close(pstmt, con);
		}
		
		return false;
	}
	
	// updateDept
	// Query : UPDATE dept SET dname =?, loc = ? WHERE deptno = ?
	public static boolean updateDept(Dept dept) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql = "UPDATE dept SET dname =?, loc = ? WHERE deptno = ?";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
		}finally {
			DBUtil.close(pstmt, con);
		}
		
		return false;
	}
	
	// deleteDept
	// Query : DELETE FROM dept WHERE deptno = ?
	public static boolean deleteDeptByDeptno(int deptno) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;

		int result = 0;
		
		String sql = "DELETE FROM dept WHERE deptno = ?";
		
		try {
			con = DBUtil.getConnection();
			
			// ?
			
		}finally {
			DBUtil.close(pstmt, con);
		}
		
		return false;
	}
}
