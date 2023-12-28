package step02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import model.domain.Student;

class StudentNoComparator implements Comparator<Student>{
	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getStudentNo() > o2.getStudentNo()) {
			return 1;
		} else if (o2.getStudentNo() > o1.getStudentNo()) {
			return -1;
		}
		return 0;
	}
}

public class ListSort {

	public static void main(String[] args) {
		// sort
		ArrayList<Integer> integerList = new ArrayList<Integer>();
		ArrayList<String> stringList = new ArrayList<String>();
		// 34, 25, 45, 11, 8
		integerList.add(34);
		integerList.add(25);
		integerList.add(45);
		integerList.add(11);
		integerList.add(8);
		
		integerList.forEach((i) -> {
			System.out.println(i);
		});
		
		stringList.add("a");
		stringList.add("A");
		stringList.add("D");
		stringList.add("b");
		stringList.add("c");
		stringList.add("d");
		stringList.add("e");
		stringList.add("aDbe");
		
		
		
//		System.out.println(integerList);
		
		// Collections
		// 오름차순(기본)
//		Collections.sort(integerList);
//		System.out.println(integerList);
		
		//내림차순
		//Comparator라는 인터페이스 타입을 반환
//		Collections.sort(integerList, Collections.reverseOrder());
//		System.out.println(integerList);
		
		//1.8버전 이후 추가
		//list.sort() : 파라미터로 Comparator인터페이스 안의 매서드 호출
//		integerList.sort(Comparator.reverseOrder());
//		System.out.println(integerList);
//		
//		stringList.sort(Comparator.reverseOrder());
//		System.out.println(stringList);
		
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("Spring", 1004, "Junior"));
		studentList.add(new Student("Java", 1001, "Junior"));
		studentList.add(new Student("DB", 1002, "Junior"));
		
		System.out.println();
		
		// 
		Collections.sort(studentList);
		System.out.println(studentList);
		
		Collections.sort(studentList, new StudentNoComparator());
		System.out.println(studentList);
		
		
	}

}
