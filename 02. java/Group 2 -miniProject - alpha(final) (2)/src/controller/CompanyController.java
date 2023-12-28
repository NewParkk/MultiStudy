package controller;

import service.CompanyService;
import java.util.List;
import java.util.Scanner;
import dto.Company;

public class CompanyController {
    private CompanyService companyService = new CompanyService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        boolean run = true;
        while (run) {
            displayMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllCompanies();
                    break;
                case "2":
                    addCompany();
                    break;
                case "3":
                    updateCompany();
                    break;
                case "4":
                    deleteCompany();
                    break;
                case "5":
                    run = false;
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 시도하세요.");
            }
        }
    }

    private void displayMenu() {
        System.out.println("\n1. 모든 회사 보기");
        System.out.println("2. 회사 추가");
        System.out.println("3. 회사 정보 업데이트");
        System.out.println("4. 회사 삭제");
        System.out.println("5. 메인 선택창으로 돌아가기");
        System.out.print("옵션을 선택하세요: ");
    }

    private void showAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        System.out.println("===================");
        for (Company company : companies) {
            System.out.println(company);
        }
        System.out.println("===================");
    }

    private void addCompany() {
        System.out.print("이름: ");
        String name = sc.nextLine();
        System.out.print("기술 (쉼표로 구분): ");
        String skillInput = sc.nextLine();
        String[] skills = skillInput.split(",");
        System.out.print("요구 경력: ");
        int career;
        try {
            career = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요."); 
            return;
        }

        Company newCompany = new Company(name, skills, career);
        companyService.addCompany(newCompany);
    }

    private void updateCompany() {
        System.out.print("업데이트할 회사의 이름: ");
        String name = sc.nextLine();

        List<Company> companies = companyService.searchCompaniesByName(name);
        if (companies.isEmpty()) {
            System.out.println("해당 이름의 회사가 없습니다.");
            return;
        }

        Company company = companies.get(0);
        System.out.print("새 이름 (현재: " + company.getName() + "): ");
        String newName = sc.nextLine();
        System.out.print("새 기술 (쉼표로 구분) (현재: " + String.join(", ", company.getSkill()) + "): ");
        String newSkillInput = sc.nextLine();
        String[] newSkills = newSkillInput.split(",");
        System.out.print("새 요구 경력 (현재: " + company.getCareer() + "): ");
        int newCareer;
        try {
            newCareer = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        companyService.updateCompany(company, newName, newSkills, newCareer);
        System.out.println("회사 정보가 업데이트되었습니다.");
    }

    private void deleteCompany() {
        System.out.print("삭제할 회사의 이름: ");
        String name = sc.nextLine();

        List<Company> companies = companyService.searchCompaniesByName(name);
        if (companies.isEmpty()) {
            System.out.println("해당 이름의 회사가 없습니다.");
            return;
        }

        Company company = companies.get(0);
        companyService.deleteCompany(company);
        System.out.println("회사가 목록에서 삭제되었습니다.");
    }
}

// 메뉴 출력 로직 분리 (displayMenu 메소드 사용)
// sc 관련 일관성
// Dev con 이랑 변경 사항 동일함
