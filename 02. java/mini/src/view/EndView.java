package view;

import java.util.ArrayList;

import dto.Developer;
import dto.ITCompany;

public class EndView {
	
	//모든 개발자 출력
	public static void developerListView(ArrayList<Developer> allDevelopers) {
		for(int i = 0; i < allDevelopers.size();i++) {
			System.out.println(allDevelopers.get(i));
			System.out.println();
		}
	}
	
	
	//이름받아온 개발자 출력
	public static void developerView(Developer developer) {
		System.out.println(developer);
	}
	
	
	//개발자와 매칭되는 회사 출력
	public static void itcompanyView(ITCompany itcompany) {
		System.out.println(itcompany);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}