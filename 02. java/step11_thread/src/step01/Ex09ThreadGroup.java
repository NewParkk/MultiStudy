package step01;

// 데몬 스레드
class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업 내용 저장");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save();
		}
	}
}

// 스레드 그룹
class StudyThread extends Thread {
	
	public StudyThread(ThreadGroup threadGroup, String threadName) {
		super(threadGroup, threadName);
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(getName() + "interrupted");
				break;
			}
		}
		System.out.println(getName() + "종료");
	}
}

public class Ex09ThreadGroup {
	public static void main(String[] args) {
		// 데몬 스레드
		
//		AutoSaveThread auto = new AutoSaveThread();
//		auto.setDaemon(true);
//		auto.start();
//		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		
		
		// 스레드 그룹
		ThreadGroup dev = new ThreadGroup("dev");
		StudyThread java = new StudyThread(dev, "java");
		StudyThread js = new StudyThread(dev, "js");
		
		
		// thread는 group으로 관리할 수 있다
		// 다만 thread를 실행시키는것은 각각 실행시켜야함
		
		java.start();
		js.start();
		
		
		dev.interrupt();
		
		
		
		
		
		
		
		// 스레드 그룹
		
	}
}