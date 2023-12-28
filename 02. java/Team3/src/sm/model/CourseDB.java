package sm.model;

import java.util.ArrayList;

import sm.dto.Course;

public class CourseDB {
	public static CourseDB course = new CourseDB();
	public ArrayList<Course> Courses = new ArrayList<>();
	
	public CourseDB() {
		Courses.add(new Course("프론트엔드","0001","김강사",3));
		Courses.add(new Course("백엔드","0002","박강사",5));
		Courses.add(new Course("풀스택","0003","이강사",2));
	}
	
	public static CourseDB getCourse() {
		return course;
	}
	
	// 모든 프로젝트 반환_
	public ArrayList<Course> getCourseList(){
		return Courses;
	}
	
	public void insertCourse(Course newProject) {
		Courses.add(newProject);
	}
	
	// 삭제_
	public void deleteCourse(Course project) {
		Courses.remove(project);
	}
}