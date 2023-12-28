package service;

import db.CompanyDB;
import db.DeveloperDB;
import dto.Company;
import dto.Developer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SearchService {
	private CompanyDB companyDB;
	private DeveloperDB developerDB;

	public SearchService() {
		this.companyDB = CompanyDB.getInstance();
		this.developerDB = DeveloperDB.getInstance();
	}

	public List<Company> recommendCompaniesForDeveloper(String developerName) {
		Developer developer = developerDB.getDeveloperList().stream()
				.filter(d -> d.getName().equalsIgnoreCase(developerName)).findFirst().orElse(null);

		if (developer == null) {
			return new ArrayList<>();
		}

		List<String> developerSkills = Arrays.asList(developer.getSkill());
		return companyDB.getCompanyList().stream()
				.filter(company -> Arrays.stream(company.getSkill()).anyMatch(developerSkills::contains))
				.collect(Collectors.toList());
	}

	public List<Developer> recommendDevelopersForCompany(String companyName) {
		Company company = companyDB.getCompanyList().stream().filter(c -> c.getName().equalsIgnoreCase(companyName))
				.findFirst().orElse(null);

		if (company == null) {
			return new ArrayList<>();
		}

		List<String> companySkills = Arrays.asList(company.getSkill());
		return developerDB.getDeveloperList().stream()
				.filter(developer -> Arrays.asList(developer.getSkill()).stream().anyMatch(companySkills::contains))
				.collect(Collectors.toList());
	}
}
// 비슷한 패턴의 코드가 반복되고 있음, 별도의 메소드로 분리하는 게 좋을 것 같음
// 개선 필요