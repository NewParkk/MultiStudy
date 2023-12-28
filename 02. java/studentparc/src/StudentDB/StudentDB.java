package StudentDB;

import java.util.ArrayList;

import model.domain.Studentmodel;

public class StudentDB {
	private static StudentDB instance = new StudentDB();
	private ArrayList<Studentmodel> information = new ArrayList<>();
	
	private StudentDB() {
		information.add(new Studentmodel("기린", 15, 1, "1학년", "달리기"));
		information.add(new Studentmodel("코끼리", 22, 2, "3학년", "먹기"));
		information.add(new Studentmodel("원숭이", 15, 3, "5학년", "나무타기"));
		information.add(new Studentmodel("악어", 15, 4, "6학년", "수영"));
		information.add(new Studentmodel("독수리", 15, 5, "2학년", "날기"));
		information.add(new Studentmodel("두더지", 15, 6, "4학년", "구멍파기"));
	}
	public static StudentDB getInstance(){
			return instance;
	}
	public ArrayList<Studentmodel> getStudenttList(){
	return information;
	}
	public void insertStudent(Studentmodel newStudent) {
		information.add(newStudent);
		
	}
	public void DeleteStudent(Studentmodel dlstudent) {
		information.remove(dlstudent);
	}
}

