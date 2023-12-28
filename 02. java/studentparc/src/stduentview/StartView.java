package stduentview;

import java.util.Scanner;
import model.domain.Studentmodel;
import studentcontroll.StudentController;

public class StartView {

	public static void main(String[] args) {
		Studentmodel newstudent = new Studentmodel("나비", 23, 07, "4학년","꿀먹기");
		StudentController controller = StudentController.getInstance();

		//System.out.println("===== 1. 모든 학생 검색  =====");
		//controller.studentListView();
		//System.out.println("===== 2. 새로운 학생 저장 및 확인 =====");
		//controller.insertinformatio(newstudent);
		//controller.studentListView();
		//System.out.println("===== 3. 존재하는 학생 검색 =====");
		//controller.ListView("감마");
		//System.out.println("===== 4. 존재하지 않는 학생 검색 - 예외처리 =====");
		
		//System.out.println("===== 5. 존재하는 학생 수정 및 확인 =====");
		/*controller.ListView("기린");
		controller.updateinformation("기린","잠자리");
		controller.ListView("기린");
		controller.ListView("기린");
		controller.ListView("잠자리");*/
		//System.out.println("===== 6. 존재하는 학생 삭제 및 확인 =====");
		//controller.ListView("기린");
		//controller.deleteinformation("기린");
		//controller.ListView("기린");
	}

}
