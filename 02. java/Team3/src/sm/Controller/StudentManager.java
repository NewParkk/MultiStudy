package sm.Controller;
 
import java.util.ArrayList;
import java.util.Scanner;

import sm.dto.Student;
import sm.model.CourseDB;
import sm.model.StudentDB;
import sm.dto.Course;
 
public class StudentManager {
    
	private CourseDB course = new CourseDB();
	private StudentDB studentDB = new StudentDB();
	
    private ArrayList<Student> students;
    private Scanner s = new Scanner(System.in);
    
    public StudentManager()
    {
        this.students = new ArrayList<>();    // Student형 변수 배열 생성
    }
    
    public void addNewStudents(Student student)    
    {
    	// course(enrolledStudentList) add
    	for(int i=0; i< course.getCourseList().size(); i++) {
    		if(course.getCourseList().get(i).getCourseName().equals((student.courseName))) {
    			course.getCourseList().get(i).addStudent(student);
    			studentDB.getStudentList().add(student);
    		}
    	}
        
        System.out.println("추가가 완료되었습니다!");
    }
    
    public void deleteStudents(int studentNum)
    {
        boolean isTargetThere = false;
        ArrayList<Student> students = studentDB.getStudentList();
        for(int i = 0; i < students.size(); i++)    
        {
            if ( students.get(i).getStudentNum() == studentNum )
            {
                int tempNum = students.get(i).getStudentNum();
                students.remove(i);
                System.out.println( tempNum + " 학생의 삭제가 완료되었습니다.");
                isTargetThere = true;
                break;
            }
        }
        
        System.out.println( !isTargetThere ? "입력하신 학번이 존재하지 않습니다." : "");
    }
    
	public void editStudents(int studentNum) throws Exception 
	{
		boolean isTargetThere = false;
		ArrayList<Student> students = studentDB.getStudentList();
		for(int i=0; i<students.size(); i++) 
		{
			if ( students.get(i).getStudentNum() == studentNum )
	        {
				isTargetThere = true;
                
                System.out.println("학번: " + students.get(i).getStudentNum());
                System.out.println("이름: " + students.get(i).getStudentName());
//                System.out.print("나이 입력: ");
//                students.get(i).setStudentAge(s.next());
                System.out.print("강좌명 입력 : ");
                try {
                	students.get(i).setCourseName(s.next());
				} catch (Exception e) {
					System.out.println("존재하지 않는 강좌입니다.");
				}
				System.out.println("----------------------");
				break;
                
//                int toEditStdNum = inputStudentNum(false);
//                if (toEditStdNum == 0)
//                    System.out.println("학번 정보를 변경하지 않았습니다.");
//                else 
//                    students.get(i).setStudentNum(toEditStdNum); 
	                        
	        }
		}
		
			System.out.println( !isTargetThere ? "입력하신 학번이 존재하지 않습니다." : "");
	}
     
  
  

    public void printStudentList()
    {
        System.out.println("학번\t이름\t나이\t강좌명");
 
 
        for(Student student : studentDB.getStudentList())    
        {
            printOneStudent(student);
        }
 
    }
    
    public void printOneStudent(Student student)
    {
        System.out.println(student.getStudentNum()+"\t"+    
                student.getStudentName()+"\t"+    
                student.getStudentAge()+"\t"+
                student.getCourseName());
    }
    
    public int inputStudentNum(boolean isFirstInput)
    {
        while(true)
        {
            int tempNum = 0;
            try {
                if (isFirstInput)
                {
                    System.out.print("입력할 학번 입력(숫자만): ");
                }
                else
                {
                    System.out.print("수정할 학번 입력(0 입력시 변경하지 않음): ");
                }                
                
                tempNum = Integer.parseInt(s.nextLine());
                
                return tempNum;            
            }
            catch(Exception e)
            {
                System.err.println("숫자만 입력하실 수 있습니다. 다시 입력해주세요.");
            }
        }        
    }    
    
    
    public String inputStudentName(boolean isFirstInput)
    {
        while(true)
        {
            try {
                System.out.print(isFirstInput ? "등록" : "수정");
                System.out.print("할 이름 입력: ");
                return s.nextLine();
            }
            catch (Exception e)
            {
                System.err.println("입력 오류가 발생했습니다. 다시 입력해주세요.");
            }
        }
        
    }
    
    public int inputStudentAge(boolean isFirstInput)
    {
        while(true)
        {
            int tempNum = 0;
            try {
                if (isFirstInput)
                {
                    System.out.print("나이 입력(숫자만): ");
                }
                else
                {
                    System.out.print("수정할 나이 입력(0 입력시 변경하지 않음): ");
                }                
                
                tempNum = Integer.parseInt(s.nextLine());
                
                return tempNum;            
            }
            catch(Exception e)
            {
                System.err.println("숫자만 입력하실 수 있습니다. 다시 입력해주세요.");
            }
        }        
    }    
    
    public String inputcourseName(boolean isFirstInput)
    {
        while(true)
        {
            try {
            	System.out.print(isFirstInput ? "등록" : "수정");
                System.out.print("할 강좌 번호: ");
                int courseNum = s.nextInt();
                Course selectedCourse = course.getCourseList().get(courseNum -1);
	        	if(selectedCourse.getmax() > selectedCourse.getEnrolledStudents().size()) {
	        		return selectedCourse.getCourseName();
	        	}else {
	        		System.out.println("이 강좌는 최대 수강인원이 초과되었습니다.");
	        		return null;
	        	}
                
            }
            catch(Exception e){ 
                System.err.println("에러입니다. 다시 입력해주세요.");
            }
        }
        
    }
    
    
    public void inputNewStudent()
    {
    	// create Student
        int stdNum = inputStudentNum(true);
        String stdName = inputStudentName(true);
        int stdAge = inputStudentAge(true);
        
    	// showCourses
        System.out.println("<수강할 강좌 선택>");
    	for(int i = 0; i < course.getCourseList().size(); i++) {
    		System.out.println("강좌 번호 : " + (i + 1) + course.getCourseList().get(i).getCourseName());
    	}
    	
        String csName = inputcourseName(true);
        
//        new Student(stdNum, stdName, stdAge, csName)
        Student newStudent = new Student(stdNum, stdName, stdAge, csName);
        if(newStudent.getCourseName() != null) {
        	addNewStudents(newStudent);   
        }
         
    }

	public ArrayList<Course> showTestCourseInfo() {
		return course.getCourseList();
	}
	
	public ArrayList<Student> showTestStudentInfo() {
		return studentDB.getStudentList();
	}

  
}