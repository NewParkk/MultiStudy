package bank.management.controller;

import java.util.Optional;

import bank.management.dto.Account;
import bank.management.service.BankManagementService;
import bank.management.view.EndView;
import bank.management.view.FailView;

//예외처리 
public class BankManagementController {
	BankManagementService service = BankManagementService.getInstance();

	// 전체 계좌 출력  
	public void allAccountsGet (){
		 EndView.allAccountsView(service.getAllAccounts());
	}
	
	//Id로 계좌 검색
	public void accountSearch(String Id) {
		try {
			EndView.accountView(service.searchAccount(Id));
		} catch (Exception e) {
			FailView.failMessageView("존재하지 않는 계좌");
		}
	}
	
	// 잔액확인
	public void balanceGet(String Id) {
		try {
			EndView.balanceView(service.getBalance(Id));
		} catch (Exception e) {
			FailView.failMessageView("존재하지 않는 계좌");
		}
	}
	
	//입금
	public void moneyIn(String Id, int money) {
		try {
			EndView.MessgaeView("입금 성공");
			balanceGet(Id);
		} catch (Exception e) {
			FailView.failMessageView(e.getMessage());
		}
	}
	
	//출금 
	public void moneyGet(String Id, int money) {
		try {
			money = service.getMoney(Id, money);
			EndView.MessgaeView("출금 성공");
			balanceGet(Id);
		} catch (Exception e) {
			FailView.failMessageView("존재하지 않는 계좌");
		}
		if (money == -1) {
			FailView.failMessageView("잔액 부족");
		}
	}
	
	//계좌 생성
		public void accountInsert (Account newAccount) {
		EndView.MessgaeView(service.insertAccount(newAccount));
	}
	
	//계좌 삭제
	public void deleteAccount(String Id, String residentNum) {
		try {
			Account account = service.deleteAccount(Id, residentNum);
			if (Optional.ofNullable(account).isPresent()) {
				EndView.MessgaeView("삭제 성공");
			} else {
				FailView.failMessageView("주민등록번호가 일치하지 않음");
			}
		} catch (Exception e) {
			FailView.failMessageView("존재하지 않는 Id");
		}
	}
}
