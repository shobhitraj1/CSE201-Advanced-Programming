package org.IIITD.Question_2;

import java.util.*;

public class q2_main {
    public static void main(String[] args) {
        Address a1 = new Address("Sector 45","Noida","UP",110040);
        Address a2 = new Address("Sector 25","Patna","Bihar",109000);
        Address a3 = new Address("Sector 15","Dwarka","Delhi",110010);
        Address a4 = new Address("Sector 16","Noida","UP",110100);
        Address a5 = new Address("Sector 110","Gurgaon","Haryana",110080);
        Student s1 = new Student("s1",9.8,2022,"dayScholar", a1);
        Student s2 = new Student("s2",7.8,2021,"dayScholar",a2);
        Student s3 = new Student("s3",6.8,2023,"dayScholar",a3);
        Student s4 = new Student("s4",8.0,2020,"dayScholar",a4);
        Student s5 = new Student("s5",8.7,2022,"dayScholar",a5);
        ArrayList<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        DistanceComp distcomp = new DistanceComp();
        students.sort(distcomp);
        System.out.println("Ranks on the basis of distance (higher to lower): ");
        for (Student s: students){
            System.out.print(s.getFirstName() + " ");
        }
        System.out.println();
        CgpaComp cgpaComp = new CgpaComp();
        students.sort(cgpaComp);
        System.out.println("Ranks on the basis of cgpa (lower to higher): ");
        for (Student s: students){
            System.out.print(s.getFirstName() + " ");
        }
        System.out.println();
        JointComp jointComp = new JointComp();
        students.sort(jointComp);
        System.out.println("Ranks on the basis of joint criteria: ");
        for (Student s: students){
            System.out.print(s.getFirstName() + " ");
        }
        System.out.println();
        for (int i=0; i<3;i++){
            students.get(i).setResidentialStatus("onCampus");
        }
        System.out.println("The mode of going to work: ");
        System.out.print("s1: ");
        s1.goToWork();
        System.out.print("s2: ");
        s2.goToWork();
        System.out.print("s3: ");
        s3.goToWork();
        System.out.print("s4: ");
        s4.goToWork();
        System.out.print("s5: ");
        s5.goToWork();

    }
}
