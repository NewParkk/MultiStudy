package step01.api;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Ex02Utill {
	public static void main(String[] args) {
		// Calender
		
		Calendar cal = Calendar.getInstance();
//		System.out.println(cal.get(Calendar.YEAR));
//		System.out.println(cal.get(Calendar.MONTH));
//		
//		cal.set(2023, 12, 25);
//		System.out.println(cal.get(Calendar.MONTH));
		
		// Date
		Date date = new Date();
		System.out.println(date);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String changedDate = sdf.format(date);
		System.out.println(changedDate);
		
		// 추가)
		// 1. Calendar -> Date
		Calendar calendar = new GregorianCalendar(2023, 12, 25);
		Date toDateValue = calendar.getTime();
		System.out.println(toDateValue.getClass());
		
		// 2. Date -> Calendar
		Date date2 = new Date();
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
