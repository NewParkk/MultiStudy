package bank.management.model;

import java.util.ArrayList;

import bank.management.dto.*;

public class BankManagementDB {
	private static BankManagementDB instance = new BankManagementDB();
	private ArrayList<Account> accounts = new ArrayList<Account>();
	
	private BankManagementDB() {
		accounts.add(new Account(new People("Jo", "asdf", "950102-1548974"), "51846817", 1850000 ));
		accounts.add(new Account(new People("LEE","qwer", "970315-2145783"),"24556883", 250000));
		accounts.add(new Account(new People("JEON", "BBBB", "960410-111118"), "51846444", 1860000));
		accounts.add(new Account(new People("Hw", "ws0398", "970720-12345113"), "99999999", 1950002 ));
	
	}
	
	public static BankManagementDB getInstance() {
		return instance;
	}
	
	// 전체 계좌 반환
	public ArrayList<Account> getAccountList() {
		return accounts;
	}
	
	// 계좌 생성
	public void insertAccount(Account newAccount) {
		accounts.add(newAccount);
	}

	// 계좌 삭제
	public void deleteAccount(Account newAccount) {
		accounts.remove(newAccount);		
	}


}
