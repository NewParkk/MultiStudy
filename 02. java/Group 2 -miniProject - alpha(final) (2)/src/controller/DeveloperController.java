package controller;

import service.DeveloperService;
import java.util.List;
import java.util.Scanner;
import dto.Developer;

public class DeveloperController {
    private DeveloperService developerService = new DeveloperService();
    private Scanner sc = new Scanner(System.in);

    public void start() {
        boolean run = true;
        while (run) {
            displayMenu();
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    showAllDevelopers();
                    break;
                case "2":
                    addDeveloper();
                    break;
                case "3":
                    updateDeveloper();
                    break;
                case "4":
                    deleteDeveloper();
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
        System.out.println("\n1. 모든 개발자 보기");
        System.out.println("2. 개발자 추가");
        System.out.println("3. 개발자 정보 업데이트");
        System.out.println("4. 개발자 삭제");
        System.out.println("5. 메인 선택창으로 돌아가기");
        System.out.print("옵션을 선택하세요: ");
    }

    private void showAllDevelopers() {
        List<Developer> developers = developerService.getAllDevelopers();
        System.out.println("===================");
        for (Developer developer : developers) {
            System.out.println(developer);
        }
        System.out.println("===================");
    }

    private void addDeveloper() {
        System.out.print("이름: ");
        String name = sc.nextLine();

        // 이름에 숫자가 포함되어 있는지 확인
        if (name.matches(".*\\d.*")) {
            System.out.println("이름에 숫자가 포함될 수 없습니다. 다시 입력해주세요.");
            return;
        }

        System.out.print("기술 (쉼표로 구분): ");
        String skillInput = sc.nextLine();
        String[] skills = skillInput.split(",");

        System.out.print("경력: ");
        int career;
        try {
            career = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        Developer newDeveloper = new Developer(name, skills, career);
        developerService.addDeveloper(newDeveloper);
    }


    private void updateDeveloper() {
        System.out.print("업데이트할 개발자의 이름: ");
        String name = sc.nextLine();

        List<Developer> developers = developerService.searchDeveloperByName(name);
        if (developers.isEmpty()) {
            System.out.println("해당 이름의 개발자가 없습니다.");
            return;
        }

        Developer developer = developers.get(0);

        System.out.print("새 이름 (현재: " + developer.getName() + "): ");
        String newName = sc.nextLine();

        System.out.print("새 기술 (쉼표로 구분) (현재: " + String.join(", ", developer.getSkill()) + "): ");
        String skillInput = sc.nextLine();
        String[] newSkill = skillInput.split(",");

        System.out.print("새 경력 (현재: " + developer.getCareer() + "): ");
        int newCareer;
        try {
            newCareer = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
            return;
        }

        developerService.updateDeveloper(developer, newName, newSkill, newCareer);
        System.out.println("개발자 정보가 업데이트되었습니다.");
    }

    private void deleteDeveloper() {
        System.out.print("삭제할 개발자의 이름: ");
        String name = sc.nextLine();

        List<Developer> developers = developerService.searchDeveloperByName(name);
        if (developers.isEmpty()) {
            System.out.println("해당 이름의 개발자가 없습니다.");
            return;
        }

        Developer developer = developers.get(0);
        developerService.deleteDeveloper(developer);
        System.out.println("개발자가 삭제되었습니다.");
    }
}

// 메뉴 출력 분리 (displayMenu) 메뉴 표시 코드 중복 제거
// sc.nextInt() / nextLine() 조합은 입력 관련 문제가 생길 수 있어 sc.nextLine()으로 변경. 통일성
// InputMismatchException 과 Exception 예외를 따로 처리했으나 하나의 catch 블록에서 처리했음
