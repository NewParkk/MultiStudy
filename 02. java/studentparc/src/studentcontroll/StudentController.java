package studentcontroll;

import java.util.ArrayList;

import Student.service.Studentservice;
import model.domain.Studentmodel;
import stduentview.EndView;
import stduentview.FailView;

public class StudentController {
	private static StudentController instance = new StudentController();
	private Studentservice service = Studentservice.getInstance();

	private StudentController() {
	}

	public static StudentController getInstance() {
		return instance;
	}

//모든 학생 검색
	public void studentListView() {
		ArrayList<Studentmodel> studentList = service.getAllStudent();
		EndView.studentListView(studentList);
	}

//특정학생 검색
	public void ListView(String studentName) {
		Studentmodel project;
		try {
			project = service.getStudent(studentName);
			EndView.StudentListView(project);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FailView.failMessageView(e.getMessage());

		}

	}
	
	//모든 학생
	public void studentall() {
		ArrayList<Studentmodel> studentList = service.getAllStudent();
		EndView.studentListView(studentList);
	}

	
//	새로운 학생정보 저장
	public void insertinformatio(Studentmodel newStudent) {
		service.studentInsert(newStudent);
	}

	// 학생정보 수정
	// ???
	public void updateinformation(String studentname, String stName) {

		try {
			service.studentUpdate(studentname, stName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FailView.failMessageView(e.getMessage());
		}

	}

	// 이름으로 검색한 학생정보 삭제
	public void deleteinformation(String name) {
		try {
			service.studentDelete(name);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			FailView.failMessageView(e.getMessage());
		}

	}

}