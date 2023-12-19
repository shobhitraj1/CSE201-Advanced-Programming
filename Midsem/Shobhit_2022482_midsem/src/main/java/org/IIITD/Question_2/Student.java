package org.IIITD.Question_2;

import java.util.Objects;

public class Student extends Person {
    private double cgpa;
    private int startYear;
    private String residentialStatus;
    private int distance;

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
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

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Student(String firstName, double cgpa, int startYear, String residentialStatus, Address addr) {
        this.setFirstName(firstName);
        this.cgpa = cgpa;
        this.startYear = startYear;
        this.residentialStatus = residentialStatus;
        this.setAddr(addr);
        this.distance();
    }

    private void distance() { //helper method -> hence private
        if (this.getAddr().getPincode() >= 110020) this.distance = this.getAddr().getPincode() - 110020;
        else this.distance = 110020 - this.getAddr().getPincode();
    }

    @Override
    public void goToWork() {
        if (Objects.equals(this.residentialStatus, "onCampus")) System.out.println("Walks to work");
        else System.out.println("Goes by Vehicle");
    }
}
