package employeesPairs;

import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) {
		try {
			Employees employees = new Employees("test");
			System.out.println(employees.maxTimeTogetherOnSameProject());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (CustomDateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();	
		}
	}	
}
