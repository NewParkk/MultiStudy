package sm.dto;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseName;
    private String courseCode;
    private String instructor;
    private List<Student> enrolledStudents;
    private int max;
    public Course(String courseName, String courseCode, String instructor, int max) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.instructor = instructor;
        this.max = max;
        this.enrolledStudents = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
    public String getCourseCode() {
        return courseCode;
    }
    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
    public String getInstructor() {
        return instructor;
    }
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }
    public void setEnrolledStudents(List<Student> enrolledStudents) {
        this.enrolledStudents = enrolledStudents;
    }
    public int getmax() {
        return max;
    }
    public void setmax(int max) {
        this.max = max;
    }
    public boolean addStudent(Student student) {
        if (enrolledStudents.size() < max) {
            enrolledStudents.add(student);
            return true;
        }
        return false;
    }
	@Override
	public String toString() {
		return "Course [courseName=" + courseName + ", courseCode=" + courseCode + ", instructor=" + instructor
				+ ", enrolledStudents=" + enrolledStudents + ", max=" + max + "]";
	}
}