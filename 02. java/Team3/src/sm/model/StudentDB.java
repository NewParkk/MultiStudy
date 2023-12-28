package sm.model;

import java.util.ArrayList;

import sm.dto.Student;


public class StudentDB {
	public static StudentDB student = new StudentDB();
	public ArrayList<Student> students = new ArrayList<>();
	
	public StudentDB() {
		students.add(new Student(120001, "이예림", 23, "프론트엔드"));
		students.add(new Student(120002, "신예현", 21, "풀스택"));
		students.add(new Student(120003, "양혁진", 24, "프론트엔드"));
        students.add(new Student(120004, "박준희", 25, "풀스택"));
        students.add(new Student(120005, "김자바", 26, "백엔드"));    
        students.add(new Student(120006, "이름", 21, "풀스택"));
	}
	
	public static StudentDB getStudent() {
		return student;
	}
	
	// 모든 프로젝트 반환_
	public ArrayList<Student> getStudentList(){
		return students;
	}
	
	public void insertStudent(Student newStudent) {
		students.add(newStudent);
	}
	
	// 삭제_
	public void deleteStudent(Student student) {
		students.remove(student);
	}
}

