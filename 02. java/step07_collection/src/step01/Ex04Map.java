package step01;

import java.util.ArrayList;
import java.util.HashMap;

public class Ex04Map {
	public static void main(String[] args) {
		// HashMap
		// 기본타입은 hash데이터의 키나 밸류값으로 지정 불가능
		HashMap<String, Integer> hm1 = new HashMap<String, Integer>();
		
		//put()
		hm1.put("a", 1);
		hm1.put("b", 2);
		hm1.put("c", 3);
		hm1.put("d", 4);
		hm1.put("e", 5);
		// 키값이 존재하는데 넣으면 갱신됨
		hm1.put("a", 6);
		
		System.out.println(hm1);
		// get()
		System.out.println(hm1.get("c"));
		
		// remove()
		
		//
		ArrayList<String> al2 = new ArrayList<String>();
		al2.add("a");
		al2.add("b");
		al2.add("c");
		
		HashMap<String, ArrayList> hm2 = new HashMap<String, ArrayList>(); 
		hm2.put("al2", al2);
		
		System.out.println(hm2);
		
		// b 출력?
		System.out.println(al2.get(1));
		System.out.println(hm2.get("al2").get(1));
		
		//
		HashMap<String, HashMap> hm3 = new HashMap<String, HashMap>();
		hm3.put("hm2", hm2);
		System.out.println(hm3);
		System.out.println(((ArrayList)hm3.get("hm2").get("al2")).get(1));
		
		
		
		
		
		
	}

}
