package Student.service;

import java.util.ArrayList;

import StudentDB.StudentDB;

import model.domain.Studentmodel;
import stduentview.EndView;


public class Studentservice {
	private static  Studentservice instance = new  Studentservice();
	private StudentDB studentData = StudentDB.getInstance();
	String msg = ("검색 요청하신 학생은 존재하지 않습니다");

	
	
	private Studentservice () {}
	public static Studentservice getInstance() {
		return instance;
	}
	
	
	
	
	public ArrayList<Studentmodel> getAllStudent() {
		return studentData.getStudenttList();
	}
	
	public Studentmodel getStudent(String stName) throws Exception {
		ArrayList<Studentmodel> stList = studentData.getStudenttList();
		Studentmodel stexception = null;
		for(int i = 0; i<stList.size(); i++) {
			if(stList.get(i) != null && stList.get(i).getName().equals(stName)) {
				stexception = stList.get(i);
			}
		}
		if(stexception == null) {
			throw new Exception("검색 요청하신 학생은 존재하지 않습니다");
		}
		return stexception;
		
			
	}
	
	public void studentInsert(Studentmodel newStudent) {
		if(newStudent != null) {
			studentData.insertStudent(newStudent);
		}
	}
	
	public void studentUpdate(String studentname, String stName) throws Exception {
		Studentmodel student = getStudent(studentname);
		student.setName(stName);
	
	}
	
	public void studentDelete(String dtName)throws Exception {
		Studentmodel stDelete = getStudent(dtName);
		studentData.DeleteStudent(stDelete);
	}
	

	
	
}
