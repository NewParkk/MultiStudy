package service;

import java.util.ArrayList;

import db.CompanyDB;
import dto.Company;

public class CompanyService {
	private CompanyDB companyDB = CompanyDB.getInstance();

	public ArrayList<Company> getAllCompanies() {
		return companyDB.getCompanyList();
	}

	public void addCompany(Company company) {
		companyDB.insertCompany(company);
	}

	public void updateCompany(Company company, String name, String[] skill, int career) {
		companyDB.updateCompany(company, name, skill, career);
	}

	public void deleteCompany(Company company) {
		companyDB.removeCompany(company);
	}

	public ArrayList<Company> searchCompaniesByName(String name) {
		ArrayList<Company> result = new ArrayList<>();
		for (Company company : companyDB.getCompanyList()) {
			if (company.getName().equalsIgnoreCase(name)) {
				result.add(company);
			}
		}
		return result;
	}
}

// ArrayList 대신 List 사용하는 게 좋았을 거 같음, 유연성이 떨어짐
// 데이터 양이 많아질 경우 스트림 사용이 권장됨