package view;

import controller.DeveloperController;
import dto.Developer;

public class StartView {
	public static void main(String[] args) {
		DeveloperController controller = DeveloperController.getInstance();
		
		Developer newDeveloper = new Developer("e","java",2);
		
		// 모든 개발자 검색
//		System.out.println("모든 개발자 검색");
		controller.developerListView();
				
		
		// 새로운 개발자 추가
//		System.out.println("새로운 개발자 명단 추가");
		controller.insertDeveloper(newDeveloper);
		controller.developerListView();
		
		
		// 존재하는 개발자 검색
//		System.out.println("개발자 이름으로 검색");
//		controller.developerView("c");
		
		
		// 개발자 정보 수정
//		System.out.println("검색한 개발자정보 수정");
//		controller.updateDeveloper("b", new Developer("f","python",1));
//		System.out.println("수정된 정보 확인");
//		controller.developerListView();
		
		
		// 개발자 정보 삭제
//		System.out.println("검색한 개발자 명단 삭제");
//		controller.deleteDeveloper("c");
//		controller.developerListView();
		
		
		
		
		// 개발자 이름으로 skill매칭되는 회사 검색
		System.out.println("검색한 개발자 skill 매칭");
		controller.companyMatching("a");
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
