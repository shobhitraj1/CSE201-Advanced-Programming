package midsem.q2;

import java.util.Comparator;

public class DistanceCGPAComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		double lhsDistanceCGPA = (o1.getAddress().getPincode() - 110020) - 6*o1.getCGPA();
		double rhsDistanceCGPA = (o2.getAddress().getPincode() - 110020) - 6*o2.getCGPA();
		
		if (lhsDistanceCGPA < rhsDistanceCGPA)
			return -1;
		else if (lhsDistanceCGPA > rhsDistanceCGPA)
			return 1;
		else
			return 0;
	}
}
