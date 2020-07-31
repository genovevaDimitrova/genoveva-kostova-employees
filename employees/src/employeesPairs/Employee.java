package employeesPairs;

import java.text.ParseException;
import java.time.LocalDate;


public class Employee {

	private Integer empID;
	private Integer projectID;
	private LocalDate dateFrom;
	private LocalDate dateTo;
	
	Employee(int empID, int projectID, LocalDate dateFrom, LocalDate dateTo) throws CustomDateException {
		this.empID = empID;
		this.projectID = projectID;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		if(dateTo.compareTo(dateFrom) < 0) {
			throw new CustomDateException("Wrong input!");
		}
	}
	
	Employee(String empID, String projectID, String dateFrom, String dateTo) throws ParseException, CustomDateException {
		this.empID = Integer.parseInt(empID);
		this.projectID = Integer.parseInt(projectID);
		this.dateFrom = DateFormatter.formatDate(dateFrom); 
		this.dateTo = DateFormatter.formatDate(dateTo);
		if(dateTo.compareTo(dateFrom) < 0) {
			throw new CustomDateException("Wrong input!");
		}
	}
	
	//used for HashSet to remove duplicates
	@Override
	public int hashCode() {
	    return (this.empID + this.projectID + this.dateFrom.hashCode() + this.dateFrom.hashCode());
	}
	//used for HashSet to remove duplicates
	@Override
    public boolean equals(Object o) { 
		if(o instanceof Employee)
        {
			Employee temp = (Employee) o;

			if(this.empID.equals(temp.empID) && this.projectID.equals(temp.projectID) && 
					this.dateFrom.equals(temp.dateFrom) && this.dateTo.equals(temp.dateTo))
                return true;
        }
        return false;
    } 
	
	public Integer getID() {
		return this.empID;
	}
	
	public int getProjectID() {
		return this.projectID;
	}
	
	public LocalDate getDateTo() {
		return this.dateTo;
	}
	
	public LocalDate getDateFrom() {
		return this.dateFrom;
	}
 }
