package employeesPairs;

import java.util.List;
import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Employees {
	
	private Integer maxKey1;
	private Integer maxKey2;
	private HashMap<Integer, HashMap<Integer, Duration>> map;
	
	Employees(String file) throws ParseException, CustomDateException, IOException  {
		this.map = new HashMap<Integer, HashMap<Integer, Duration>>();
		this.calculate(EmployeeFileReader.readFile(file));
	}
	
	public void incrementDurationOn(int key1, int key2, Duration duration) {
		HashMap<Integer, Duration> newMap = new HashMap<Integer,Duration>();
		if(this.map.containsKey(key1)) {
			if(this.map.containsKey(key2)) {
				newMap = this.map.get(key1);
				newMap.put(key2, newMap.get(key2).plus(duration));
			}
			else {
				newMap = new HashMap<Integer, Duration>();
				newMap.put(key2, duration);
			}
			
		} else {
			newMap = new HashMap<Integer, Duration>();
			newMap.put(key2, duration);
		}
		this.map.put(key1, newMap);
	}
	
	public void calculate(List<Employee> employees) { 
		employees = new ArrayList<Employee>(new HashSet<Employee>(employees));	
		this.maxKey1 = null;
		this.maxKey2 = null;
		
		for(Employee emp1 : employees) {
			for(Employee emp2 : employees) {
				if(emp1.getID() == emp2.getID()) { //if the same employee - skip
					continue;
				}
				if(emp1.getProjectID() == emp2.getProjectID()) { // if they worked on the same project, increment Duration
					this.incrementDurationOn(emp1.getID(), emp2.getID(),
							UnionOfTwoIntervals.getUnionOfTwoIntervals(emp1.getDateFrom(),
									emp2.getDateFrom(), emp1.getDateTo(), emp2.getDateTo()));

					if(this.maxKey1 == null && this.maxKey2 == null) {
						this.maxKey1 = emp1.getID();
						this.maxKey2 = emp2.getID();
					}
					// if the current indexes duration is bigger(after the increment) update the max indexes
					if(this.map.get(emp1.getID()).get(emp2.getID()).compareTo(this.map.get(maxKey1).get(maxKey2)) > 0) {
						this.maxKey1 = emp1.getID();
						this.maxKey2 = emp2.getID();
					}
				}
			}
		}
	}
	
	
	public String maxTimeTogetherOnSameProject() {
		if(this.map.containsKey(maxKey1) && this.map.containsKey(maxKey2)) {
			if(this.map.get(maxKey1).get(maxKey2).abs().getSeconds() == 0) 
				return "There's no existing pair";
			else
				return "The employee with id: " + this.maxKey1 + 
					" and employee with id: " + this.maxKey2 + " were working together " + this.map.get(maxKey1).get(maxKey2).abs().getSeconds()/3600 + " hours.";
		}
		else {
			return "There's no existing pair";
		}
	}
}
