package employeesPairs;

import java.time.Duration;
import java.time.LocalDate;

public class UnionOfTwoIntervals {

	public static Duration getUnionOfTwoIntervals(LocalDate start1, LocalDate start2,
			LocalDate end1, LocalDate end2) {
		
		if(start1.compareTo(start2) > 0) {
			if(start2.compareTo(end1) > 0) {
				return Duration.ZERO;
			}
			if(end1.atStartOfDay().compareTo(end2.atStartOfDay()) > 0) {
				return Duration.between(start1.atStartOfDay(),end2.atStartOfDay());
			}
			else {
				return Duration.between(start1.atStartOfDay(), end1.atStartOfDay());
			}
		}		
		else {
			if(start1.compareTo(end2) > 0) {
				return Duration.ZERO;
			}
			if(end1.atStartOfDay().compareTo(end2.atStartOfDay()) > 0) {
				return Duration.between(start2.atStartOfDay(),end2.atStartOfDay());
			}
			else {
				return Duration.between(start2.atStartOfDay(), end1.atStartOfDay());
			}
		}
	}
}
