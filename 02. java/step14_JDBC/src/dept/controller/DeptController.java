package dept.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import dept.dto.Dept;
import dept.service.DeptService;

public class DeptController {
	public static DeptController instance = new DeptController();
	
	public static DeptController getInstance() {
		return instance;
	}
	
	public static ArrayList<Dept> getAllDept() {
		
		ArrayList<Dept> deptList = null;
		try {
			deptList = DeptService.getAllDept();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return deptList;
	}
	
	
	// 특정 부서 출력
	public static Dept getDeptByDeptno(int deptno) {
		Dept dept = null;
		
		try {
			dept = DeptService.getDeptByDeptno(deptno);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dept;
	}
	
	// 특정 부서 생성
	public static boolean intsertDept(Dept newDept) {
		boolean result = false;
		try {
			result = DeptService.insertDept(newDept);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 특정 부서 수정
	public static boolean updateLoc(int deptno, String newLoc) {
	    boolean result = false;
	    try {
	        result = DeptService.updateLoc(deptno, newLoc);
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	
	
	// 특정 부서 삭제
	public static boolean deleteDept(int deptno) {
	    boolean result = false;
	    try {
	        result = DeptService.deleteDept(deptno);
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }
	    return result;
	}
	
	
}
