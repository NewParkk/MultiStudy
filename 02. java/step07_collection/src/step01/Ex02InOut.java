package step01;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Ex02InOut {
	public static void main(String[] args) {
		// Stack : LIFO
		Stack<String> card = new Stack<String>();
		
		//push()
		card.push("우리");
		card.push("신한");
		card.push("토스");
		
		System.out.println(card);
		
		//pop()
		System.out.println(card.pop());
		System.out.println(card);
		System.out.println(card.pop().getClass());
		
		
		
		// isEmpty()
		System.out.println(card.isEmpty());
		//	capacity() 디폴트 10의 공간
		System.out.println(card.capacity());
		
		System.out.println();
		
		// Queue : FIFO
		Queue<String> drinkBox = new LinkedList<String>();
		
		// offer()
		drinkBox.add("Coke");
		drinkBox.add("Dr.Pepper");
		drinkBox.add("Sprite");
		
		// poll()
		System.out.println(drinkBox);
		drinkBox.poll();
		System.out.println(drinkBox);
		
		
		
		
	}

}
