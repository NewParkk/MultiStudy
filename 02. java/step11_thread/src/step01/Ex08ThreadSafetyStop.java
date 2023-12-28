package step01;

class InterruptedThread extends Thread {
	
	@Override
	public void run() {
		while(true) {
			System.out.println("무한 실행 중입니다.");
			
			if(Thread.interrupted()) {
				System.out.println("실행 종료합니다.");
				break;
			}
		}
	}
}

public class Ex08ThreadSafetyStop {
	public static void main(String[] args) {
		InterruptedThread iThread = new InterruptedThread();
		iThread.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		iThread.interrupt();
	}
}