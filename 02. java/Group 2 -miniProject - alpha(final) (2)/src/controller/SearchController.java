package controller;

import dto.Company;
import dto.Developer;
import service.SearchService;
import java.util.List;
import java.util.Scanner;

public class SearchController {
	private SearchService searchService;
	private Scanner scanner;

	public SearchController() {
		this.searchService = new SearchService();
		this.scanner = new Scanner(System.in);
	}

	public void start() {
		while (true) {
			displayMenu();
			String choice = scanner.nextLine();

			switch (choice) {
			case "1":
				recommendCompaniesForDeveloper();
				break;
			case "2":
				recommendDevelopersForCompany();
				break;
			case "3":
				System.out.println("프로그램을 종료합니다.");
				return;
			default:
				System.out.println("잘못된 선택입니다. 다시 시도하세요.");
			}
		}
	}

	private void displayMenu() {
		System.out.println("1. 개발자에게 추천하는 회사 찾기");
		System.out.println("2. 회사에게 추천하는 개발자 찾기");
		System.out.println("3. 종료\n");
		System.out.print("선택: ");
	}

	private void recommendCompaniesForDeveloper() {
		System.out.print("개발자 이름: ");
		String name = scanner.nextLine();
		List<Company> companies = searchService.recommendCompaniesForDeveloper(name);

		if (companies.isEmpty()) {
			System.out.println();
			System.out.println("추천할 회사가 없습니다.");
		} else {
			for (Company company : companies) {
				System.out.println(company);
			}
		}
	}

	private void recommendDevelopersForCompany() {
		System.out.print("회사 이름: ");
		String name = scanner.nextLine();
		List<Developer> developers = searchService.recommendDevelopersForCompany(name);

		if (developers.isEmpty()) {
			System.out.println();
			System.out.println("추천할 개발자가 없습니다.");
		} else {
			for (Developer developer : developers) {
				System.out.println(developer);
			}
		}
	}
}
// 메뉴 출력 로직 분리
// 다른 컨트롤러 변경점에 기반한 최적화 ++
// 기타 오류가 아직 존재중 개선 필요
