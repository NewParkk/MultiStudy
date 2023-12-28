package step01;

class Thread1 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println((i+1)+ "번 실행");
		}
	}
}

class Thread2 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 10; i ++) {
			System.out.println((i+1)+ "번 실행");
		}
	}
	
}




public class Ex01Thread {
	public static void main(String[] args) {
		Runnable thred1  = new Thread1();
		Runnable thred2  = new Thread2();
		
		
		//Runnable 타입 실행방법
		Thread t1 = new Thread(thred1);
		Thread t2 = new Thread(thred2);
		
		
		//start실행시 run()호출
		t1.start();
		t2.start();
		
		
		
		
		
		
	}

}
