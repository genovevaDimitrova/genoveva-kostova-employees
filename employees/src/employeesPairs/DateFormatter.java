package employeesPairs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatter {
	public static String DateFormat = "yyyy-MM-dd";
	public static String tillNowValue = "null";
	
	public static LocalDate formatDate(String date) {
		if(date.toLowerCase().equals(DateFormatter.tillNowValue)) {
			return LocalDate.parse(new SimpleDateFormat(DateFormatter.DateFormat).format(new Date()), DateTimeFormatter.ofPattern(DateFormatter.DateFormat));
		}
		else
			return LocalDate.parse(date, DateTimeFormatter.ofPattern(DateFormatter.DateFormat));
	}
}
