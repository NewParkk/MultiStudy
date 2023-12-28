package sm.dto;

 
public class Student {
    
//    학생정보
//    -학번
//    -이름
//	  -나이
//	  -수강하는 강좌명
//    -------입력 받음-----
    
    public int studentNum;
    public String studentName;
    public int studentAge;
    public String courseName;

    public Student(int studentNum, String studentName, int studentAge, String courseName) {
		super();
		this.studentNum = studentNum;
		this.studentName = studentName;
		this.studentAge = studentAge;
		this.courseName = courseName;
	}

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public int getStudentAge() {
		return studentAge;
	}

	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	@Override
	public String toString() {
		return "Student [studentNum=" + studentNum + ", studentName=" + studentName + ", studentAge=" + studentAge
				+ ", courseName=" + courseName + "]";
	}
}