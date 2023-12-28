package stduentview;

import java.util.ArrayList;

import Student.service.Studentservice;
import model.domain.Studentmodel;

public class EndView {

	// 모든 학생 출력
	public static void studentListView(ArrayList<Studentmodel> allSSProjects) {
		for(int i = 0; i < allSSProjects.size(); i++)
			System.out.println(allSSProjects.get(i));
			System.out.println();
	}

	// 특정 학생 출력 (1명의 학생)
	public static void StudentListView(Studentmodel project) {
		System.out.println(project);
	}

	// 예외가 아닌 단순 메시지 출력??
	public static void messageView(String message) {
		System.out.println(message);
	}
	
	
}