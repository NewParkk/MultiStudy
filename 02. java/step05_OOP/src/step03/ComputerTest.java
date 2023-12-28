package step03;

public class ComputerTest {

	public static void main(String[] args) {
//		Computer computer = new Computer(); // 추상클래스기 때문에 객체생성 불가능
		Computer deskTop = new DeskTop();
		deskTop.display(); // 데스크탑 출력 완료
		
		Computer lapTop = new LapTop();
		lapTop.display(); // 랩탑 출력 완료
		
	}

}
