package controller;

import java.util.ArrayList;

import dto.Developer;
import dto.ITCompany;
import service.DeveloperService;
import view.EndView;

public class DeveloperController {
	private static DeveloperController instance = new DeveloperController();
	private DeveloperService service = DeveloperService.getInstance();
	
	 
	private DeveloperController() {}
	
	public static DeveloperController getInstance() {
		return instance;
	}
	
	//모든 개발자 검색
	public void developerListView() {
		ArrayList<Developer> developerList = service.getAllDevelopers();
		EndView.developerListView(developerList);
	}
	
	
	
//	public ArrayList<Developer> getAllDevelopers() {
//	       return developerDB.getDeveloperList();
//	    }
	
	
	
	
	//개발자 이름으로 검색
	public void developerView(String developerName) {
		Developer developer;
		developer = service.searchDevelopersByName(developerName);
		EndView.developerView(developer);
	}
	
	
	// 개발자 추가
	public void insertDeveloper(Developer newDeveloper) {
		service.projectInsert(newDeveloper);
	}
	
	// 개발자 수정
	public void updateDeveloper(String developername, Developer developer) {
		try {
			service.developerUpdate(developername, developer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 개발자 삭제
	public void deleteDeveloper(String developerName) {
		service.developerDelete(developerName);
	}
	
	
	// 개발자의 skill이 매칭되는 회사 검색
	public void companyMatching(String matchname) {
				ITCompany itcompany;
				itcompany = service.matchingskill(matchname);
				EndView.itcompanyView(itcompany);
			
			}
		
}	