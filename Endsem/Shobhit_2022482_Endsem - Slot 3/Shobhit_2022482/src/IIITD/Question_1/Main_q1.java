package IIITD.Question_1;

import java.util.Objects;

public class Main_q1 {
    public static void main(String[] args) {
        //let's create 3 file managers and ensure that only one instance of the file manager is created
        //this is the Client class - named Main_Q1 for easy navigating
        FileManager fm1 = FileManager.getInstance(1,"Ram");
        FileManager fm2 = FileManager.getInstance(2,"Shyam");
        FileManager fm3 = FileManager.getInstance(2,"Shyam");
        FileManager fm4 = FileManager.getInstance(4,"Raju");
        //printing using toString and checking if all same
        System.out.println(fm1.toString());
        System.out.println(fm2.toString());
        System.out.println(fm3.toString());
        System.out.println(fm4.toString());
        //checking using equals method
        System.out.println("The result of fm1 & fm2: " + fm1.equals(fm2)); //returns true means they are same even though different ID and Name (hence ensuring only one file manager)
        System.out.println("The result of fm1 & fm3: " + fm1.equals(fm3));
        System.out.println("The result of fm1 & fm4: " + fm1.equals(fm4));
        System.out.println("The result of fm2 & fm3: " + fm2.equals(fm3));
        System.out.println("The result of fm2 & fm4: " + fm2.equals(fm4));
        //They all return true ensuring only one file manager in the entire system

    }
}
