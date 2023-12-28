package step01;

import java.util.HashSet;
import java.util.Iterator;

public class Ex03Set {
	public static void main(String[] args) {
		// HashSet
		HashSet<String> hashSet = new HashSet<String>();
		
		// add()
		hashSet.add("Java");
		hashSet.add("IT");
		hashSet.add("Study");
		hashSet.add("Happy");
		hashSet.add("Lazy");
		hashSet.add("Lazy");
		hashSet.add("Lazy");
		
		System.out.println(hashSet);
		
		// 조회
		for(String word : hashSet) {
			System.out.println(word);
		}
		System.out.println();
		// Iterator
		Iterator<String> iter = hashSet.iterator();
		while(iter.hasNext()) {
			String v = iter.next();
			System.out.println(v);
		}
		
		System.out.println();
		// 추가
		System.out.println(hashSet.isEmpty());
		System.out.println(hashSet.contains("IT"));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
