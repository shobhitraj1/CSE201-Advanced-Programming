package org.IIITD;

import java.util.Scanner;

public class Main {
    static void takeInput() {
        System.out.println("------------------------------");
        System.out.println("Select the option:-");
        System.out.println("1. Enter as a librarian");
        System.out.println("2. Enter as a member");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1 -> Librarian.displayLInput();
            case 2 -> {
                System.out.print("Enter your Member ID: ");
                int m_id = sc.nextInt();
                int d=0;
                for (Member m1 : Library.members) {
                    if (m1.getMem_id() == m_id) {
                        System.out.println("Welcome " + m1.getName() + "! Member ID: " + m1.getMem_id());
                        Member.displayMInput(m1);
                        d++;
                        break;
                    }
                }
                if (d==0) {
                    System.out.println("Member with ID " + m_id + " doesn't exist");
                    System.out.println("You can register the member using Librarian mode (Select 1 to log in as Librarian)");
                    takeInput();
                }
            }
            case 3 -> System.out.println("Thanks for using IIITD Library Portal!");
            default -> System.out.println("Choose and enter valid option from 1-3");
        }
        sc.close();
    }
    public static void main(String[] args) {

        System.out.println("Welcome to IIITD Library Portal!");
        takeInput();

    }
}