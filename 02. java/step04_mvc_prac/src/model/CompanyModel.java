package model;

import java.util.ArrayList;

import model.domain.Company;

public class CompanyModel {
	
	private static ArrayList<Company> all_c_data = new ArrayList<>();
	private static int index;
	
	
	static {
		all_c_data.add(new Company("T1","강남",6000,"java"));
		all_c_data.add(new Company("KT","서초",4000,"python"));
		all_c_data.add(new Company("LG","송파",5000,"c"));
	}
	
	// 모든 회사 검색
	public static ArrayList<Company> getAll() {
		return all_c_data;
	}
	
	// 한 개의 회사 조회
	public static Company getOne(String name) {
		
		for (Company company : all_c_data) {
			if (company != null && company.getName().equals(name)) {
				return company;
			} else {
				System.out.println("없는 회사명 입니다.");
			}
		}
		
		return null;
	}
	
	
	public static boolean insert(Company company) {
		// 배열에 새로운 학생 객체를 저장
		// 주의사항 : 최대 5개까지 데이터가 저장
		if (company != null && index < all_c_data.size()) {
			all_c_data.add(company);
			return true;
		} 
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
