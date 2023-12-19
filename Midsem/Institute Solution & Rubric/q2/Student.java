package midsem.q2;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
	
	private double cgpa;
	private int startYear;
	private String residentialStatus;
	
	private static final String ON_CAMPUS = "onCampus";
	private static final String DAY_SCHOLAR = "dayScholar";
	
	public Student(String firstName, String lastName, int id, Address address, 
			double cgpa, int startYear, String residentialStatus) {
		super(firstName, lastName, id, address);
		this.cgpa = cgpa;
		this.startYear = startYear;
		this.residentialStatus = residentialStatus;
	}

	public double getCGPA() {
		return cgpa;
	}

	public void setCGPA(double cgpa) {
		this.cgpa = cgpa;
	}

	public int getStartYear() {
		return startYear;
	}

	public void setStartYear(int startYear) {
		this.startYear = startYear;
	}

	public String getResidentialStatus() {
		return residentialStatus;
	}

	public void setResidentialStatus(String residentialStatus) {
		this.residentialStatus = residentialStatus;
	}

	@Override
	public void goToWork() {
		if (residentialStatus == DAY_SCHOLAR)
			System.out.println("Go by vehicle");
		else if (residentialStatus == ON_CAMPUS)
			System.out.println("Go by walk");
	}
	
	@Override
	public String toString() {
		return "Name: " + getFirstName() + " " + getLastName() + "\n" + 
				"ID: " + getId() + "\n" + 
				"CGPA: " + getCGPA() + "\n" + 
				"Pincode: " + getAddress().getPincode() + "\n" + 
				"Residential Status: " + getResidentialStatus();
	}
	
	public static void main(String[] args) {
		List<Student> studentList = new ArrayList<Student>();
		
		Address address1 = new Address("Mayur Vihar", "New Delhi", "Delhi", 110024);
		Address address2 = new Address("Kalkaji", "New Delhi", "Delhi", 110015);
		Address address3 = new Address("Govindpuri", "New Delhi", "Delhi", 110022);
		Address address4 = new Address("Saket", "New Delhi", "Delhi", 110006);
		Address address5 = new Address("GK1", "New Delhi", "Delhi", 110029);
				
		studentList.add(new Student("f1", "l1", 123, address1, 4.5, 2021, DAY_SCHOLAR));
		studentList.add(new Student("f2", "l2", 456, address2, 5.5, 2020, DAY_SCHOLAR));
		studentList.add(new Student("f3", "l3", 777, address3, 6.5, 2022, DAY_SCHOLAR));
		studentList.add(new Student("f4", "l4", 888, address4, 5.3, 2022, DAY_SCHOLAR));
		studentList.add(new Student("f5", "l5", 999, address5, 8.5, 2021, DAY_SCHOLAR));
		
		System.out.println("Distance based ranking" + "\n");
		studentList.sort(new DistanceComparator());
		for(Student s : studentList)
			System.out.println(s);
		
		System.out.println("\nCGPA based ranking" + "\n");
		studentList.sort(new CGPAComparator());
		for(Student s : studentList)
			System.out.println(s);
		
		System.out.println("\nDistance-CGPA based ranking" + "\n");
		studentList.sort(new DistanceCGPAComparator());
		for(Student s : studentList)
			System.out.println(s);
		
		studentList.get(0).setResidentialStatus(ON_CAMPUS);
		studentList.get(1).setResidentialStatus(ON_CAMPUS);
		studentList.get(2).setResidentialStatus(ON_CAMPUS);
		
		System.out.println("\nDistance-CGPA based ranking with residential status changed" + "\n");
		for(Student s : studentList)
			System.out.println(s);
	}
}
