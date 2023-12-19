package org.IIITD;

import java.util.ArrayList;

// abstract class Visitors serves as parent class & provides blueprint for any type of visitor
public abstract class Visitors {
    private String visitorName;
    private int visitorAge;
    private long visitorPhone;
    private int visitorBalance;
    private String visitorEmail;
    private String visitorPass;
    private int experienceLevel; //  0 --> None ; 1 --> Basic ; 2 --> Premium (Membership level)
    private boolean isStudent;
    private boolean isSenior;
    private int visitorID;
    private boolean hasVisited;
    private ArrayList<String> attractionTickets;
    private static int noofvisitors = 0;

    public Visitors(String visitorName, int visitorAge, long visitorPhone, int visitorBalance, String visitorEmail, String visitorPass, int visitorID) {
        this.visitorName = visitorName;
        this.visitorAge = visitorAge;
        this.visitorPhone = visitorPhone;
        this.visitorBalance = visitorBalance;
        this.visitorEmail = visitorEmail;
        this.visitorPass = visitorPass;
        this.experienceLevel = 0; // When register, has no membership --> have to buy using option 2
        this.isStudent = false; // By default, no discount
        this.isSenior = false; // By default, no discount
        this.hasVisited = false; // By default, hasn't visited any attraction/animal
        this.visitorID = visitorID;
        this.attractionTickets = new ArrayList<>();
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public int getVisitorAge() {
        return visitorAge;
    }

    public void setVisitorAge(int visitorAge) {
        this.visitorAge = visitorAge;
    }

    public long getVisitorPhone() {
        return visitorPhone;
    }

    public void setVisitorPhone(long visitorPhone) {
        this.visitorPhone = visitorPhone;
    }

    public int getVisitorBalance() {
        return visitorBalance;
    }

    public void setVisitorBalance(int visitorBalance) {
        this.visitorBalance = visitorBalance;
    }

    public String getVisitorEmail() {
        return visitorEmail;
    }

    public void setVisitorEmail(String visitorEmail) {
        this.visitorEmail = visitorEmail;
    }

    public String getVisitorPass() {
        return visitorPass;
    }

    public void setVisitorPass(String visitorPass) {
        this.visitorPass = visitorPass;
    }

    public int getExperienceLevel() {
        return experienceLevel;
    }

    public void setExperienceLevel(int experienceLevel) {
        this.experienceLevel = experienceLevel;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public boolean isSenior() {
        return isSenior;
    }

    public void setSenior(boolean senior) {
        isSenior = senior;
    }

    public int getVisitorID() {
        return visitorID;
    }

    public void setVisitorID(int visitorID) {
        this.visitorID = visitorID;
    }

    public boolean isHasVisited() {
        return hasVisited;
    }

    public void setHasVisited(boolean hasVisited) {
        this.hasVisited = hasVisited;
    }

    public ArrayList<String> getAttractionTickets() {
        return attractionTickets;
    }

    public void setAttractionTickets(ArrayList<String> attractionTickets) {
        this.attractionTickets = attractionTickets;
    }

    public static int getNoofvisitors() {
        return noofvisitors;
    }

    public static void setNoofvisitors(int noofvisitors) {
        Visitors.noofvisitors = noofvisitors;
    }
}
