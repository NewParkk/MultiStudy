package view;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class EndView {
    private static final String FILE_PATH = "feedback.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void showEndMessageCollectFeedback() {
        System.out.println("프로그램을 종료합니다.");
        collectFeedback();
    }

    private static void collectFeedback() {
        System.out.println("프로그램에 대한 피드백을 남겨주세요:");
        String feedback = scanner.nextLine();

        saveFeedbackToFile(feedback);
    }

    private static void saveFeedbackToFile(String feedback) {
        try (FileWriter fileWriter = new FileWriter(FILE_PATH, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            printWriter.println(now.format(formatter) + " - " + feedback);
            System.out.println("\n피드백이 '" + FILE_PATH + "' 파일에 저장되었습니다.\n파일은 프로그램이 실행되는 디렉토리에 저장됩니다.");
        } catch (IOException e) {
            System.out.println("피드백을 저장하는데 오류가 발생했습니다: " + e.getMessage());
        }
    }
}

// Scanner를 전역 객체로 변경했음, 파일경로 변경 시 한 곳에서만 수정 가능