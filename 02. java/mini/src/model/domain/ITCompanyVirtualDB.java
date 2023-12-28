package model.domain;

import java.util.ArrayList;

import dto.Developer;
import dto.ITCompany;

public class ITCompanyVirtualDB {
	private static ITCompanyVirtualDB instance = new ITCompanyVirtualDB();
	private ArrayList<ITCompany> itcompanyList = new ArrayList();
	
	private ITCompanyVirtualDB() {
		itcompanyList.add(new ITCompany("웹개발","Java", 5));
		itcompanyList.add(new ITCompany("앱개발","Python", 1));
		itcompanyList.add(new ITCompany("PB","JavaScript", 3));
	}
	
	public static ITCompanyVirtualDB getInstance() {
        return instance;
    }
	
	
	//모든 회사 반환
	 public ArrayList<ITCompany> getCompanyList() {
	        return itcompanyList;
	 }
	
	
	
	
	
	
	
	
}
