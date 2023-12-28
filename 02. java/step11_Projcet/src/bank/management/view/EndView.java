package bank.management.view;

import java.util.ArrayList;

import bank.management.dto.Account;
import lombok.val;

public class EndView {
	
	// 전체 계좌 출력 
	public static void allAccountsView (ArrayList<Account> allAccount){
		
		for (int i = 0; i < allAccount.size(); i++) {
			System.out.println((i + 1) + "번 계좌 : " + allAccount.get(i));
		}
	}
	
	// 잔액 출력
	public static void balanceView(int money) {
		System.out.println("잔액 : " + money);
	}
	
	// 특정 계좌 출력 
	public static void accountView (Account account) {
		System.out.println(account);
	}
	
	// 단순 메시지
	public static void MessgaeView(String message) {
		System.out.println(message);
	}
	
}
