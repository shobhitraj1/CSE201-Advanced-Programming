package org.IIITD.Question_3;

import java.util.Scanner;

public class q3_main {
    public static boolean correctPin(int pincode){
        if(pincode>=100000 && pincode<=999999) return true;
        if (pincode/100000 != 0) return true;
        else return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pincode;
        boolean done = true;
        while (done){
            try{
                pincode = sc.nextLine();
                int pin = Integer.parseInt(pincode);
                if (correctPin(pin)){
                    System.out.println("Pin: "+pin);
                    done= false;
                }
                else {
                    throw new IncorrectPincodeException("Invalid pincode. Enter again.");
                }
            } catch (IncorrectPincodeException e) {
                System.out.println(e.getMessage());
                System.out.println(e.toString());
//                e.printStackTrace();
            }
        }
    }
}
