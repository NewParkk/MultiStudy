package sm.View;
 
import java.util.ArrayList;
import java.util.Scanner;

import sm.Controller.StudentManager;
import sm.dto.Course;
import sm.dto.Student;
 
public class StartView {
    
    public static void main(String[] args) {
        StudentManager sm = new StudentManager();
        Scanner s = new Scanner(System.in);        
        
        while(true)
        {
            System.out.println("<< 학생 관리 시스템 >>");
            System.out.println("1. 신규 정보 등록");
            System.out.println("2. 학생 목록 출력");
            System.out.println("3. 학생 정보 삭제");
            System.out.println("4. 학생 정보 수정");
            System.out.println("5. 프로그램 종료");
            System.out.print(">> ");
            String menu = s.nextLine();
            System.out.println();
            
            switch(menu)    {
            case "0":
                System.out.println("-- 테스트 정보 입력 --");
                ArrayList<Course> testCourseInfo = sm.showTestCourseInfo();
                System.out.println(testCourseInfo);

                ArrayList<Student> testStudentInfo = sm.showTestStudentInfo();
                System.out.println(testStudentInfo);
                
                System.out.println();
                break;                
            case "1":
                int num = 0;
                while(true)    {
                    try {
                        System.out.print("입력할 학생 수를 입력하세요. >> ");
                        num = Integer.parseInt(s.nextLine());
                        break;
                    } catch(Exception e) {
                        System.err.println("오류 발생! 숫자만 입력하실 수 있습니다! 다시 입력해주세요.");
                    }
                }
                for(int i = 1; i <= num; i++) {
                	
                	System.out.println();
                	
                	sm.inputNewStudent();
                }
                break;
            case "2":
                System.out.println("-- 학생 목록 출력 --");
                sm.printStudentList();
                System.out.println();
                break;
            case "3":
                System.out.println("-- 학생 목록 삭제 --");
                while(true)
                {
                    try {                        
                        System.out.print("삭제할 학생의 학번을 입력하세요. >> ");
                        int toRemove = Integer.parseInt(s.nextLine());
                        sm.deleteStudents(toRemove);
                        break;
                    }
                    catch(Exception e) {
                        System.err.println("에러가 발생했습니다. 숫자만 입력 가능합니다. 다시 입력해주세요.");
                    }    
                }                            
                break;
            case "4":
                System.out.println("-- 학생 목록 수정 --");
                while(true)
                {
                    try {                        
                        System.out.print("수정할 학생의 학번을 입력하세요. >> ");
                        int toEdit = Integer.parseInt(s.nextLine());
                        sm.editStudents(toEdit);
                        break;
                    }
                    catch(Exception e) {
                        System.err.println("에러가 발생했습니다. 숫자만 입력 가능합니다. 다시 입력해주세요.");
                    }
                }
                                
                break;
            case "5":
                System.out.println("프로그램 종료.");
                System.exit(0);
            default:
                System.out.println("메뉴를 다시 확인하세요.");
                
            }
      
        } 
        
    } // main 끝
    
}