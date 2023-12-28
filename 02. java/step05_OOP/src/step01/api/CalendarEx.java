package step01.api;

import java.util.Calendar;

public class CalendarEx {

	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		// 2023년 12월 20일 기준
		System.out.println("이 해의 년도 : " + today.get(Calendar.YEAR));
		System.out.println("월 : " + today.get(Calendar.MONTH));
		System.out.println("일 : " + today.get(Calendar.DATE));
		System.out.println("일 : " + today.get(Calendar.DAY_OF_MONTH)); // DATE 와 DAY_OF_MONTH는 같다.
		System.out.println("요일 : " + today.get(Calendar.DAY_OF_WEEK));
		// 1: 일요일, 2:월요일 3: 화요일 ... 7: 토요일
		System.out.println("이 달의 몇번째 요일 : " + today.get(Calendar.DAY_OF_WEEK_IN_MONTH));
		System.out.println("오전? 오후? : " + today.get(Calendar.AM_PM)); // 0: 오전 1: 오후
		System.out.println("시간(0~11) : " + today.get(Calendar.HOUR)); 
		System.out.println("시간(0~23) : " + today.get(Calendar.HOUR_OF_DAY)); 
		System.out.println("분(0~59) : " + today.get(Calendar.MINUTE)); 
		System.out.println("초(0~59) : " + today.get(Calendar.SECOND)); 
		System.out.println("1000분의 1초(0~999) : " + today.get(Calendar.MILLISECOND)); 
		
		System.out.println("이 달의 마지막 날(일수) : " + today.getActualMaximum(Calendar.DATE));
	}

}
