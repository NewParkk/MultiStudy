package dept.service;

import java.sql.SQLException;
import java.util.ArrayList;

import dept.dao.DeptDAO;
import dept.dto.Dept;

public class DeptService {
	public static DeptService instance = new DeptService();
	public static DeptService getInstance() {
		return instance;
	}
	
	// 모든 부서 출력
	public static ArrayList<Dept> getAllDept() throws ClassNotFoundException, SQLException {
		
		ArrayList<Dept> deptList = null;
		deptList = DeptDAO.getAllDept();
		return deptList;
	}
	
	public static Dept getDeptByDeptno(int deptno) throws ClassNotFoundException, SQLException {
		
		Dept dept = null;
		dept = DeptDAO.getDeptByDeptno(deptno);
		
		return dept;
	}
	
	public static boolean insertDept(Dept newDept) throws ClassNotFoundException, SQLException {
		boolean result = false;
		result = DeptDAO.intsertDept(newDept);
		return result;
	}
	
	
	public static boolean updateLoc(int deptno, String newLoc) throws ClassNotFoundException, SQLException {
	    return DeptDAO.updateLoc(deptno, newLoc);
	}
	
	public static boolean deleteDept(int deptno) throws ClassNotFoundException, SQLException {
		boolean result = false;
		result = DeptDAO.deleteDept(deptno);
		return result;
	}
}
