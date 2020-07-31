package employeesPairs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeFileReader {

	public static List<Employee> readFile(String file) throws IOException, ParseException, CustomDateException {
		List<Employee> list = new ArrayList<Employee>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("test.txt"));
			String line;
			while((line = br.readLine()) != null) {
				String [] items = line.split(", ");
				if(items.length == 4)
					list.add(new Employee(items[0], items[1],items[2],items[3]));
				else
					System.out.println("Wrong data input in line ");	
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
			e.printStackTrace();
		}
		return list;	
	}
}
