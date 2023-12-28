package db;

import java.util.ArrayList;
import dto.Company;

public class CompanyDB {
	private static CompanyDB instance = new CompanyDB();
	private ArrayList<Company> companies = new ArrayList<>();

	private CompanyDB() {
		String[] googleSkills = { "Java", "Kotlin", "Cloud" };
		companies.add(new Company("Google", googleSkills, 10));

		String[] frontendSkills = { "JavaScript", "React", "HTML/CSS" };
		companies.add(new Company("Front-End", frontendSkills, 5));
		
		String[] backendSkills = {"Java", "Spring", "DBMS"};
		companies.add(new Company("Back-End", backendSkills, 4));
	}

	public static CompanyDB getInstance() {
		return instance;
	}

	public ArrayList<Company> getCompanyList() {
		return companies;
	}

	public void insertCompany(Company newCompany) {
		companies.add(newCompany);
	}

	public void removeCompany(Company company) {
		companies.remove(company);
	}

	public void updateCompany(Company company, String name, String[] skill, int career) {
		if (companies.contains(company)) {
			company.setName(name);
			company.setSkill(skill);
			company.setCareer(career);
		}
	}
}