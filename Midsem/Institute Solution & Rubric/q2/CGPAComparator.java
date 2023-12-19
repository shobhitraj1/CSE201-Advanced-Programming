package midsem.q2;

import java.util.Comparator;

public class CGPAComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		if (o1.getCGPA() < o2.getCGPA())
			return -1;
		else if (o1.getCGPA() > o2.getCGPA())
			return 1;
		else
			return 0;
	}

}
