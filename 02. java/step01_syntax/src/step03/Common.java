package step03;

public class Common {
	
	private Common() {}
	
	private static Common instance = new Common();
	
	public static Common getInstance() {
		return instance;
	}
	
	public int encount(int num) {
		return ++num;
	}
	public int discount(int num) {
		return --num;
	}
	
	
	
	
}
