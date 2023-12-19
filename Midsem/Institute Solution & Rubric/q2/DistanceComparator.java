package midsem.q2;

import java.util.Comparator;

public class DistanceComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		return -1 * (Math.abs((o1.getAddress().getPincode() - 110020)) 
				- Math.abs((o2.getAddress().getPincode() - 110020)));
		
		/* The following is equivalent.
		 * return -1 * ((o1.getAddress().getPincode()) 
				- (o2.getAddress().getPincode()));
		 */
	}
}
