package bank.management.view;

import bank.management.controller.BankManagementController;
import bank.management.dto.Account;
import bank.management.dto.People;

public class StartView {

	public static void main(String[] args) {
		BankManagementController controller = new BankManagementController();
		
		//scanner받는 리모콘도 있으면 좋을듯
		
		//전체 계좌 출력 
//		controller.getAllAccounts();
		
		//Id로 계좌 검색
//		controller.accountSearch("asdf");
		
		//입금 
		controller.moneyIn("asdf", 1);
		
		//출금
//		controller.moneyGet("asdf", 100);
//		
//		controller.moneyGet("asdf", 1850000);
//		controller.accountSearch("asdf");
//		controller.moneyGet("asdf", 1850000);
		//계좌 생성
//		controller.allAccountsGet();
//		controller.accountInsert(new Account(new People("temp", "zxcv", "111111-3111111"), "23475674", 100));
//		controller.allAccountsGet();
		
		//계좌 삭제			
//		controller.getAllAccounts();
//		controller.deleteAccount("asdf","950102-1548974");
//		controller.getAllAccounts();
		
		
		//입출금내역 
		
		
	}

}

//File 사용 시 flush 꼭쓸 것 
//FileWriter 파라미터 뒤에 true적어야 누적됨