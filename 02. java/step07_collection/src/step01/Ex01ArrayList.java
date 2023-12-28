package step01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import model.domain.Student;

public class Ex01ArrayList {
	public static void main(String[] args) {
		// ArrayList
		ArrayList al1 = new ArrayList();
		
		
		// add()
		al1.add("java");
		al1.add(3); // Integer타입으로 저장되어있음 List는 타입이 명확하지 않을떄는 기본적으로 객체타입으로 추가됨
		al1.add(new Student("java", 1001, "Junior"));
		
		// Iterrator
		// 컬렉션한정으로 사용
		Iterator<?> iter = al1.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		
		
		System.out.println(al1);
		
		// get()
		System.out.println(al1.get(2));
		al1.get(1);
		
		
		// remove()
		System.out.println(al1.remove(0));
		System.out.println(al1);

		
		for(int i = 0; i < al1.size(); i++) {
			if(al1.get(i) instanceof Student) {				
				System.out.println(((Student)al1.get(i)).getGrade());
			}
		}
		
		
		// 제네릭 Generic <Data Type> 컴파일시 타입을 체크해 주는 기능
		ArrayList<Student> al2 = new ArrayList<Student>();
//		al2.add(3); // Student 타입아니여서 오류
		
		
		
		ArrayList<String> aList = new ArrayList<String>();
		LinkedList<String> lList = new LinkedList<String>();
		
		long start;
		long end;
		
		start = System.nanoTime();
		for(int i = 0; i < 30000; i++) {
			lList.add(0, String.valueOf(i)); // 
		}
		end = System.nanoTime();
		System.out.println(end - start);
		
		 start = System.nanoTime();
			for(int i = 0; i < 30000; i++) {
				lList.get(i);
			}
			end = System.nanoTime();
	    
			System.out.println(end - start);
		// ArrayList get() : 
		// LinkedList get() : 
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
