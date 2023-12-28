package step01;

class ThreadA extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(flag) {
				System.out.println("ThreadA는 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				Thread.yield();
			}
		}
	}
}

class ThreadB extends Thread{
	private boolean stop = false;
	private boolean flag = true;
	
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	public void setStop(boolean stop) {
		this.stop = stop;
	}
	
	@Override
	public void run() {
		while(!stop) {
			if(flag) {
				System.out.println("ThreadB는 작업중");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}else {
				//다른메서드가 처리되도록 양보의 개념
				Thread.yield();
			}
		}
	}
}

class SumThread extends Thread {
	private long sum;
	
	public long getSum() {
		return sum;
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			sum += i;
		}
	}
}

public class Ex06ThreadControl {
	public static void main(String[] args) {
		// sleep()
		
		
		// yield(), stop()
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		// A, B 시작
//		threadA.start();
//		threadB.start();
		
		// A 종료
//		threadA.setFlag(false);
//		threadA.setStop(true);
		
		
		// join()
		SumThread sumThread = new SumThread();
		sumThread.start();
		
		try {
			sumThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		System.out.println("총 합: " + sumThread.getSum());
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}