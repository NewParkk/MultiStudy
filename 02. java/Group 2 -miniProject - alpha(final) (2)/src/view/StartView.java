package view;

import java.util.InputMismatchException;
import java.util.Scanner;
import controller.CompanyController;
import controller.DeveloperController;
import controller.SearchController;

public class StartView {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		CompanyController controllerC = new CompanyController();
		DeveloperController controllerD = new DeveloperController();
		SearchController controllerS = new SearchController();

		try {
			while (true) {
				displayMenu();
				int selection = getUserInput();
				processSelection(selection, controllerC, controllerD, controllerS);
			}
		} finally {
			sc.close();
		}
	}

	private static void displayMenu() {
		System.out.println("\n기능을 선택해주세요\n");
		System.out.println("0: 개발자 컨트롤러, 1: 기업 컨트롤러, 2: 매칭 추천 컨트롤러, 3: 종료\n");
		System.out.print("선택: ");
	}

	private static int getUserInput() {
		try {
			return sc.nextInt();
		} catch (InputMismatchException e) {                                           
			System.out.println("잘못된 입력입니다. 숫자를 입력해주세요.");
			sc.nextLine();
			return -1;
		}
	}

	private static void processSelection(int selection, CompanyController controllerC, DeveloperController controllerD,
			SearchController controllerS) {
		switch (selection) {
		case 0:
			controllerD.start();
			break;
		case 1:
			controllerC.start();
			break;
		case 2:
			controllerS.start();
			break;
		case 3:
			EndView.showEndMessageCollectFeedback();
			System.exit(0);
			break;
		default:
			System.out.println("잘못된 선택입니다. 다시 시도하세요.");
		}
	}
}