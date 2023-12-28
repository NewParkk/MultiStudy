package bank.management.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

import bank.management.dto.Account;
import bank.management.dto.People;
import bank.management.model.BankManagementDB;
import bank.management.view.EndView;
import lombok.val;

//실제 작업이이루어지는 공간
public class BankManagementService {
	private static BankManagementService instans = new BankManagementService();
	private BankManagementDB bankAccounts = BankManagementDB.getInstance();
	
	private BankManagementService() {}
	public static BankManagementService getInstance() {
		return instans;
	}	
	//전체불러오기
	public ArrayList<Account> getAllAccounts (){
		return bankAccounts.getAccountList();
	}	
	
	//Id로 계좌 검색
	public Account searchAccount(String Id) throws Exception {
		ArrayList<Account> allAcount = bankAccounts.getAccountList();
		Optional<Account> account = null;
		
		for (int i = 0; i < allAcount.size(); i++) {
			if (allAcount.get(i).getPeople().getId().equals(Id)) {
				account = Optional.of(allAcount.get(i));
			} 			
		}		
		return account.orElseThrow(() -> new Exception());
	}
	
	//잔액확인	
	public int getBalance(String Id) throws Exception {				
		int money = -1;
		Account account = searchAccount(Id);	
		money = account.getMoney();
		return money;
	}
	
	//입금
	public int inMoney(String Id, int money) throws Exception {
		Account account = searchAccount(Id); 
		fileSave(Id + " 입금 : " + String.valueOf(money));
		
		account.setMoney(account.getMoney() + money);
			return account.getMoney();
	}
		
	//출금
	public int getMoney(String Id, int money) throws Exception {
		Account account = searchAccount(Id);
		if (account.getMoney() - money >= 0) {
			account.setMoney(account.getMoney() - money);
			return account.getMoney();
		}
		return -1;		
	}
	
	//계좌 생성	 (중복아이디x, 주민등록번호 14자리, 계좌번호 8자리, 주민등록번호 성별번호가 올바른지 체크)
	public String insertAccount(Account newAccount) {
		ArrayList<Account> allAccounts = bankAccounts.getAccountList();
		String resisdentNum = newAccount.getPeople().getResidentNum();
				
		for (int i = 0; i < allAccounts.size(); i++) {
			Account account = allAccounts.get(i);
			if (account.getPeople().getId() != newAccount.getPeople().getId()
					&& resisdentNum.length() == 14
					&& newAccount.getAccountNum().length() == 8 ) {
				if (resisdentNum.charAt(7) == '1' || resisdentNum.charAt(7) == '2' || resisdentNum.charAt(7) == '3' || resisdentNum.charAt(7) == '4') {
					bankAccounts.insertAccount(newAccount);
					return "계좌 생성 성공";
				}
			}			
		}
		
		return "계좌 생성 실패";
	}
	
	//계좌 삭제	
	public Account deleteAccount(String Id, String residentNum) throws Exception {
		Account account = searchAccount(Id);
		
		if (account.getPeople().getResidentNum().equals(residentNum)) {
			bankAccounts.deleteAccount(account);
			return account;
		}
		
		return null;
		
	}
	
	//입출금내역
//	id 받아서 검색 -> 
//	입출금메서드에 계좌별 입출금txt로 저장 -> 
//	id와 동일한 입출금txt를 읽어옴   
	
	// 입출금 기록 메서드
	public static void fileSave(String io) throws IOException { 
		FileOutputStream fos = new FileOutputStream("ioHistory.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(io);
		oos.flush();
		oos.close();
	}
	
	// 입출금 내역 조회
	public String ioHistory(String Id) throws IOException {
		FileReader fr = new FileReader("ioHistory.txt");
		
		int a;
		while ((a = fr.read()) != -1) {
			System.out.print((char)a); // 아스키코드로 읽어오니까 변환			
		}
		return null;
	}
}
