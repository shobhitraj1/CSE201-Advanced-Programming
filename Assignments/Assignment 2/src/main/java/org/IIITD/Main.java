package org.IIITD;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    //Displays the Main Menu
    public static void takeInput(){
        String adminUsername = "admin";
        String adminPassword = "admin123";
        System.out.println("------------------------------");
        System.out.println("Select the option:-");
        System.out.println("1. Enter as Admin");
        System.out.println("2. Enter as a Visitor");
        System.out.println("3. View Special Deals");
        System.out.println("4. Exit");
        System.out.print("Enter your choice (1-4): ");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        switch (userInput) {
            case 1 -> {
                System.out.print("Enter Admin Username: ");
                sc.nextLine();
                String username = sc.nextLine();
                System.out.print("Enter Admin Password: ");
                String password = sc.nextLine();
                if (Objects.equals(username, adminUsername) && Objects.equals(password, adminPassword)) {
                    System.out.println("Successfully logged in as Admin!");
                    Admin.displayAInput();
                } else {
                    System.out.println("Username or password incorrect! Kindly enter again!");
                    Main.takeInput();
                }
            }
            case 2 -> Visitor.displayFirstInput();
            case 3 -> {
                if (Zoo.deals.isEmpty()){
                    System.out.println("Sorry! There are no special deals at the moment.");
                }
                else {
                    System.out.println("The Special deals are :-");
                    for (Deal d : Zoo.deals) {
                        System.out.println(d);
                    }
                }
                Main.takeInput();
            }
            case 4 -> System.out.println("Thanks for using ZOOtopia application!");
            default -> {
                System.out.println("Choose and enter valid option from 1-4");
                Main.takeInput();
            }
        }
    }
    public static void main(String[] args) {
        //  hard coded some attractions, animals, deals & discounts to make it easy for testing
        System.out.println("------------------------------");
        Admin.addAttraction("Jungle Safari","A thrilling adventure in the jungle.",10);
        Admin.addAttraction("Botanical Garden","Experience the perfect blend of wildlife and flora at the zoo's botanical garden attraction.",20);
        Admin.addAttraction("Dinosaur Show","Step into the past and meet the rulers of a bygone era in our thrilling dinosaur show at the zoo.",25);

        Admin.addAnimal("Lion","Mammal","Lions, often called the 'king of the jungle,' are known for their distinct roars and magnificent presence in the wild.","Roaring");
        Admin.addAnimal("Elephant","Mammal","The elephant, Earth's largest land mammal, is celebrated for its immense size, prehensile trunk, and remarkable intelligence.","Trumpeting");
        Admin.addAnimal("Green Tree Frog","Amphibian","The Green Tree Frog, Hyla cinerea, is a small, bright green amphibian known for its arboreal lifestyle and distinctive coloration.","Croaking");
        Admin.addAnimal("Tiger Salamander","Amphibian", "The Tiger Salamander, Ambystoma tigrinum, is a large, terrestrial salamander known for its distinct black and yellow tiger-like markings.","Squeaking");
        Admin.addAnimal("Crocodile","Reptile","These semi-aquatic reptiles, known for their stealth and patience, are masters of the riverbanks.","Bellowing");
        Admin.addAnimal("Komodo Dragon","Reptile","Komodo dragons are the largest lizards in the world, they are known for their predatory behavior and venomous bite.","Hissing");

        Admin.addDeal(6,40);
        Admin.addDeal(3,30);
        Admin.addDeal(2,15);

        Admin.addDiscount("Student",10,"STUDENT10");
        Admin.addDiscount("Senior",20,"SENIOR20");
        Visitor v1 = new Visitor("TA1",15,123,100,"ta1@iiitd","ta1",1); // student (minor) visitor
        v1.setStudent(true); //this feature is automatic when visitor registers using option 1 (here, we have to do this because hard coded)
        Visitor v2 = new Visitor("TA2",65,456,200,"ta2@iiitd","ta2",2); // senior visitor
        v2.setSenior(true); //this feature is automatic when visitor registers using option 1 (here, we have to do this because hard coded)
        Visitor v3 = new Visitor("TA3",30,789,150,"ta3@iiitd","ta3",3); // normal visitor (no category)
        Visitor.setNoofvisitors(Visitor.getNoofvisitors()+3); // 3 visitors hard coded to make it easier for testing
        Zoo.visitors.add(v1);
        Zoo.visitors.add(v2);
        Zoo.visitors.add(v3);
        System.out.println("3 visitors registers successfully!");
        System.out.println("------------------------------");
        System.out.println();

        System.out.println("Welcome to ZOOtopia!");
        takeInput();
    }
}