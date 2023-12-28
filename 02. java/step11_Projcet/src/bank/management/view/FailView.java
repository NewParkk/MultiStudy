package bank.management.view;

public class FailView {
	// 예외발생시 메시지
	public static void failMessageView(String massage) {
		System.out.println("발생된 상황: " + massage);
	}
}
