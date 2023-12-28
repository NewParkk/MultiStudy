package service;

import java.util.ArrayList;

import dto.Developer;
import dto.ITCompany;
import model.domain.DeveloperVirtualDB;
import model.domain.ITCompanyVirtualDB;


public class DeveloperService {
	private static DeveloperService instance = new DeveloperService();
	private DeveloperVirtualDB developerVirtualDB = DeveloperVirtualDB.getInstance();
	private ITCompanyVirtualDB itcompanyVirtualDB = ITCompanyVirtualDB.getInstance();
	
	
	
	private DeveloperService(){}
	public static DeveloperService getInstance() {
		return instance;
	}	
	// 모든 개발자 반환
	public ArrayList<Developer> getAllDevelopers() {
	       return developerVirtualDB.getDeveloperList();
	    }
	
	// 모든 IT회사 반환
	public ArrayList<ITCompany> getAllITCompany() {
		return itcompanyVirtualDB.getCompanyList();
	}
	
	
	// 개별 개발자 검색
	public Developer searchDevelopersByName(String developername) {
			for (Developer developer : developerVirtualDB.getDeveloperList()) {
				if (developer.getName().equals(developername)) {
					return developer;
				}
			}
		return null;
	}
	
	// 개발자 추가
	public void projectInsert(Developer newDeveloper) {
		if(newDeveloper != null) {
			developerVirtualDB.insertDeveloper(newDeveloper);
		}
	}
	
	
	// 새로운 개발자 정보 수정
	public void developerUpdate(String name, Developer updatedeveloper) {
			developerVirtualDB.updateDeveloper(name,updatedeveloper);
		}
		
		
		
		
		
		
//		ArrayList<Developer> developers = developerVirtualDB.getDeveloperList();
//		for (Developer updatedeveloper : developers) 
//		{
//			
//			if (updatedeveloper.getName().equals(name)) {
//				developerVirtualDB.updateDeveloper();
//				}
//		
//		}
//	}
	
	// 개발자 명단 삭제
	public void developerDelete(String developerName) {
		Developer deletedeveloper = searchDevelopersByName(developerName);
		developerVirtualDB.removeDeveloper(deletedeveloper);
	}

	
	// 개발자의 skill과 회사의 skill이 매칭되는 회사 반환
	public ITCompany matchingskill(String matchname){
		ITCompany company = null;
		for (ITCompany itcompany : getAllITCompany()) 
		{
			if(searchDevelopersByName(matchname).getSkill().equals(itcompany.getSkill()))
			{
				company = itcompany;
			}
		}
		return company;
	}
	
	
	
	
	
	
}