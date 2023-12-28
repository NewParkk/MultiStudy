package step01.api;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ex03Time {
	public static void main(String[] args) {
		// LocalDate, LocalTime
//		
//		LocalDate nowDate = LocalDate.now();
//		LocalTime nowTime = LocalTime.now();
//		System.out.println(nowDate.getDayOfMonth());
//		System.out.println(nowTime);
//		
//		LocalDateTime nowDateTime = LocalDateTime.now();
//		System.out.println(nowDateTime);
//		
//		// LocalDate => Date : valueOf
//		LocalDate localDate = LocalDate.now();
//		Date changedDate = Date.valueOf(localDate);
//		System.out.println(changedDate);
//		
//		
//	    // with
//		System.out.println(localDate.withYear(2024).withMonth(12).withDayOfMonth(25));
		
		

		
		
		
	        // 현재 날짜와 시간
	        LocalDateTime currentDateTime = LocalDateTime.now();

	        // 사용자가 원하는 형식으로 날짜와 시간을 형식화
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	        String formattedDateTime = currentDateTime.format(formatter);

	        System.out.println("Formatted DateTime: " + formattedDateTime);
	

	}
}
