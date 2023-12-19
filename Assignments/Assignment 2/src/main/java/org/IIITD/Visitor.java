package org.IIITD;

import java.util.Objects;
import java.util.Scanner;

// class Visitor contains methods for functionalities of the Visitor
public class Visitor extends Visitors implements Zoo {

    public Visitor(String visitorName, int visitorAge, long visitorPhone, int visitorBalance, String visitorEmail, String visitorPass, int visitorID) {
        super(visitorName, visitorAge, visitorPhone, visitorBalance, visitorEmail, visitorPass, visitorID);
    }

    //Provide personal information to create a visitor account
    public static void registerVisitor() {
        Scanner u = new Scanner(System.in);
        System.out.print("Enter Visitor Name: ");
        String visName = u.nextLine();
        System.out.print("Enter Visitor Age: ");
        int visAge = u.nextInt();
        System.out.print("Enter Visitor Phone Number: ");
        long visPhone = u.nextLong();
        System.out.print("Enter Visitor Balance: ");
        int visBalance = u.nextInt();
        u.nextLine();
        System.out.print("Enter Visitor Email: ");
        String visEmail = u.nextLine();
        System.out.print("Enter Visitor Password: ");
        String visPass = u.nextLine();
        for (Visitor visit : visitors) {
            if (Objects.equals(visit.getVisitorEmail(), visEmail) && Objects.equals(visit.getVisitorPass(), visPass)) {
                System.out.println("Visitor with same email & password already exists!");
                System.out.println("Kindly register using other details or use option 2 to login into your account.");
                return;
            }
        }
        int visID = Visitors.getNoofvisitors() + 1;
        Visitors.setNoofvisitors(visID);
        Visitor v = new Visitor(visName, visAge, visPhone, visBalance, visEmail, visPass, visID);
        if (visAge < 18) v.setStudent(true);
        if (visAge > 60) v.setSenior(true);
        visitors.add(v);
        System.out.println("Registration is successful.");
    }

    //Display Visitor's menu to register or login
    public static void displayFirstInput() {
        System.out.println("Select the option:-");
        System.out.println("1. Register");
        System.out.println("2. Login");
        Scanner firstInput = new Scanner(System.in);
        int visInput1 = firstInput.nextInt();
        if (visInput1 == 1) {
            Visitor.registerVisitor();
            Visitor.displayFirstInput();
        }
        if (visInput1 == 2) {
            firstInput.nextLine();
            System.out.print("Enter Visitor Email: ");
            String emailI = firstInput.nextLine();
            System.out.print("Enter Visitor Password: ");
            String passI = firstInput.nextLine();
            int foundVisitor = 0;
            for (Visitor v : visitors) {
                if (Objects.equals(v.getVisitorEmail(), emailI) && Objects.equals(v.getVisitorPass(), passI)) {
                    Visitor.displayVInput(v);
                    foundVisitor++;
                    break;
                }
            }
            if (foundVisitor == 0) {
                System.out.println("No visitor found. Incorrect Email or Password!");
                System.out.println("Kindly try again or first register yourself using Option 1");
                Visitor.displayFirstInput();
            }
        }
    }

    //Choose specific attractions/animal to view & learn more about
    public static void exploreZoo(Visitor vis) {
        System.out.println("------------------------------");
        System.out.println("Explore the Zoo :-");
        System.out.println("1. View Attractions");
        System.out.println("2. View Animals");
        System.out.println("3. Exit");
        System.out.print("Enter your choice (1-3): ");
        Scanner exploreZ = new Scanner(System.in);
        int eZ = exploreZ.nextInt();
        switch (eZ) {
            case 1 -> {
                int foundA = 0;
                if (attractions.isEmpty()) {
                    System.out.println("Sorry! There are no attractions at the moment.");
                    foundA++;
                } else {
                    System.out.println("The attractions in the zoo are:- ");
                    for (Attraction a : attractions) {
                        System.out.println(a.getAttractionName());
                    }
                    exploreZ.nextLine();
                    System.out.print("Enter the name of the attraction you want to know about: ");
                    String ezAttraction = exploreZ.nextLine();
                    for (Attraction a : attractions) {
                        if (Objects.equals(a.getAttractionName(), ezAttraction)) {
                            System.out.println("ZOOtopia offers " + a.getAttractionName() + "!!");
                            System.out.println(a.getAttractionDesc());
                            System.out.println("Buy your tickets now using option 3 in Visitor menu!");
                            foundA++;
                        }
                    }
                }
                if (foundA == 0) {
                    System.out.println("There is no attraction with this name, kindly check again & enter.");
                }
                Visitor.exploreZoo(vis);
            }
            case 2 -> {
                int foundB = 0;
                System.out.println("The animals in the zoo are:- ");
                for (Animal a : animals) {
                    System.out.println(a.getAnimalName());
                }
                exploreZ.nextLine();
                System.out.print("Enter the name of the animal you want to know about: ");
                String ezAnimal = exploreZ.nextLine();
                for (Animal a : animals) {
                    if (Objects.equals(a.getAnimalName(), ezAnimal)) {
                        a.displayDetails();
                        System.out.println("Visit this animal using option 6 in Visitor menu!");
                        foundB++;
                    }
                }
                if (foundB == 0) {
                    System.out.println("There is no animal with this name, kindly check again & enter.");
                }
                Visitor.exploreZoo(vis);
            }
            case 3 -> Visitor.displayVInput(vis);
            default -> {
                System.out.println("Choose and enter valid option from 1-3");
                Visitor.exploreZoo(vis);
            }
        }
    }

    //Purchase basic or premium memberships
    public static void buyMembership(Visitor vis) {
        int costMem;
        System.out.println("Buy Membership :-");
        System.out.println("1. Basic Membership ($20)");
        System.out.println("2. Premium Membership ($50)");
        System.out.print("Enter your choice: ");
        Scanner Mem = new Scanner(System.in);
        int buyMem = Mem.nextInt();
        Mem.nextLine();
        System.out.print("Enter Discount CODE (Enter \"None\" if you don't have any code): ");
        String buyCode = Mem.nextLine();
        if (buyMem == 1) {
            if (vis.getVisitorBalance() >= 20) {
                vis.setExperienceLevel(1);
                int discountP = applyDiscount(vis, buyCode);
                System.out.println("Basic Membership purchased successfully!");
                costMem = 20 - (discountP / 5);
                vis.setVisitorBalance(vis.getVisitorBalance() - costMem);
                Admin.setRevenue(Admin.getRevenue() + costMem);
                System.out.println("Your balance is now: $" + vis.getVisitorBalance());
            } else {
                System.out.println("You don't have sufficient balance. Kindly recharge using option 9.");
            }
        } else if (buyMem == 2) {
            if (vis.getVisitorBalance() >= 50) {
                vis.setExperienceLevel(2);
                int discountP = applyDiscount(vis, buyCode);
                System.out.println("Premium Membership purchased successfully!");
                costMem = 50 - (discountP / 2);
                vis.setVisitorBalance(vis.getVisitorBalance() - costMem);
                Admin.setRevenue(Admin.getRevenue() + costMem);
                System.out.println("Your balance is now: $" + vis.getVisitorBalance());
            } else {
                System.out.println("You don't have sufficient balance. Kindly recharge using option 9.");
            }
        }
    }

    //Apply discount codes for further savings (if available & eligible)
    public static int applyDiscount(Visitor vis, String buyCode) {
        if (Objects.equals(buyCode, "None")) {
            System.out.println("You have not applied any discount code!");
            return 0;
        }
        if (discounts.isEmpty()) {
            System.out.println("Sorry! There are no discounts at the moment.");
            return 0;
        }
        for (Discount d : discounts) {
            if (Objects.equals(d.getDiscountCode(), buyCode)) {
                if (Objects.equals(d.getDiscountCategory(), "Student")) {
                    if (vis.isStudent()) {
                        System.out.println("Student Discount coupon applied successfully! You get a discount of " + d.getDiscountPercentage() + "%");
                        return d.getDiscountPercentage();
                    } else {
                        System.out.println("You are not eligible for this discount! (Age should be less than 18)");
                        return 0;
                    }
                } else if (Objects.equals(d.getDiscountCategory(), "Senior")) {
                    if (vis.isSenior()) {
                        System.out.println("Senior Discount coupon applied successfully! You get a discount of " + d.getDiscountPercentage() + "%");
                        return d.getDiscountPercentage();
                    } else {
                        System.out.println("You are not eligible for this discount! (Age should be more than 60)");
                        return 0;
                    }
                } else {
                    System.out.println("Discount coupon applied successfully! You get a discount of " + d.getDiscountPercentage() + "%");
                    return d.getDiscountPercentage();
                }
            }
        }
        System.out.println("Sorry! There is no such discount coupon.");
        return 0;
    }

    //Purchase tickets for attractions (For Basic Members)
    public static void buyTickets(Visitor vis) {
        if (vis.getExperienceLevel() == 2) {
            System.out.println("You are a Premium Member! You don't need to buy tickets, explore the zoo for free!");
        } else if (vis.getExperienceLevel() == 0) {
            System.out.println("First buy Membership using option 2");
        } else { // Basic Member
            if (attractions.isEmpty()) {
                System.out.println("Sorry! There are no attractions at the moment.");
                return;
            }
            int costBuy = 0;
            Scanner buyT = new Scanner(System.in);
            System.out.print("Enter the number of tickets: ");
            int noofT = buyT.nextInt();
            if (noofT == 0) {
                System.out.println("Kindly buy atleast 1 ticket!");
                Visitor.buyTickets(vis);
                return;
            }
            int noofTickets = noofT;
            buyT.nextLine();
            while (noofT != 0) {
                int foundA = 0;
                System.out.println("The attractions in the zoo are :- ");
                for (Attraction a : attractions) {
                    System.out.println(a.getAttractionName() + " ($" + a.getTicketPrice() + ")");
                }
                System.out.print("Enter the name of the Attraction to Buy a Ticket: ");
                String aName = buyT.nextLine();
                for (Attraction a : attractions) {
                    if (Objects.equals(a.getAttractionName(), aName)) {
                        a.setTicketSold(a.getTicketSold() + 1);
                        vis.getAttractionTickets().add(aName);
                        costBuy += a.getTicketPrice();
                        foundA++;
                    }
                }
                noofT--;
                if (foundA == 0) {
                    System.out.println("There is no such attraction. Kindly check again & enter.");
                    noofT++;
                }
            }
            if (costBuy > vis.getVisitorBalance()) {
                System.out.println("Your balance is insufficient, kindly recharge using option 9.");
                return;
            }
            System.out.print("Enter Discount CODE (Enter \"None\" if you don't have any code): ");
            String dCode = buyT.nextLine();
            int discountP = applyDiscount(vis, dCode);
//            int discountedCost = (costBuy * (100 - discountP))/100;
            int dealP = applyDeal(noofTickets);
//            int dealCost = (discountedCost * (100 - dealP))/100;
            // total discount % = discount code % + deal %
            int finalP = discountP + dealP;
            int finalCost = (costBuy * (100 - finalP)) / 100;
            vis.setVisitorBalance(vis.getVisitorBalance() - finalCost);
            Admin.setRevenue(Admin.getRevenue() + finalCost);
            System.out.println("Your purchase of " + noofTickets + " ticket(s) is successful!");
            System.out.println("Your balance is now: $" + vis.getVisitorBalance());
        }
    }

    //Special deals applied automatically on the basis of number of tickets bought
    public static int applyDeal(int noofT) {
        if (deals.isEmpty()) {
            System.out.println("Sorry! There are no deals at the moment.");
            return 0;
        }
        for (Deal d : deals) {
            if (noofT >= d.getCombinedTickets()) {
                System.out.println("Congratulations! You are eligible for special deal as you bought >= " + d.getCombinedTickets() + " tickets together!");
                System.out.println("You get a discount of " + d.getDealPercentage() + "% on your purchase");
                return d.getDealPercentage();
            }
        }
        System.out.println("Sorry! You are not eligible for any special deal.");
        return 0;
    }

    //Displays the Visitor Mode Menu (Options for functionalities as Visitor)
    public static void displayVInput(Visitor vis) {
        System.out.println("------------------------------");
        System.out.println("Welcome " + vis.getVisitorName() + "! You have entered as Visitor. Select what you want to do:-");
        System.out.println("1. Explore the Zoo");
        System.out.println("2. Buy Membership");
        System.out.println("3. Buy Tickets");
        System.out.println("4. View Discounts");
        System.out.println("5. View Special Deals");
        System.out.println("6. Visit Animals");
        System.out.println("7. Visit Attractions");
        System.out.println("8. Leave Feedback");
        System.out.println("9. Recharge Balance");
        System.out.println("10. Log Out");
        System.out.print("Enter the option (1-10): ");
        Scanner t = new Scanner(System.in);
        int VInput = t.nextInt();
        switch (VInput) {
            case 1 -> Visitor.exploreZoo(vis);
            case 2 -> {
                Visitor.buyMembership(vis);
                Visitor.displayVInput(vis);
            }
            case 3 -> {
                Visitor.buyTickets(vis);
                Visitor.displayVInput(vis);
            }
            case 4 -> {
                if (discounts.isEmpty()) {
                    System.out.println("Sorry! There are no discount offers at the moment.");
                } else {
                    System.out.println("The discounts are :-");
                    for (Discount d : discounts) {
                        System.out.println(d);
                    }
                }
                Visitor.displayVInput(vis);
            }
            case 5 -> {
                if (deals.isEmpty()) {
                    System.out.println("Sorry! There are no special deals at the moment.");
                } else {
                    System.out.println("The Special deals are :-");
                    for (Deal d : deals) {
                        System.out.println(d);
                    }
                }
                Visitor.displayVInput(vis);
            }
            case 6 -> {
                System.out.println("Visit Animals");
                Visitor.visitAnimal(vis);
                Visitor.displayVInput(vis);
            }
            case 7 -> {
                System.out.println("Visit Attractions");
                Visitor.visitAttraction(vis);
                Visitor.displayVInput(vis);
            }
            case 8 -> {
                System.out.print("Enter your feedback: ");
                t.nextLine();
                String f = t.nextLine();
                feedback.add(f);
                System.out.println("Thank you for your feedback!");
                Visitor.displayVInput(vis);
            }
            case 9 -> {
                System.out.println("Your current balance is: $" + vis.getVisitorBalance());
                System.out.print("Enter the amount you want to recharge: ");
                int bal = t.nextInt();
                vis.setVisitorBalance(vis.getVisitorBalance() + bal);
                System.out.println("Your updated balance is: $" + vis.getVisitorBalance());
                Visitor.displayVInput(vis);
            }
            case 10 -> {
                System.out.println("Logged out!");
                Main.takeInput();
            }
            default -> {
                System.out.println("Choose and enter valid option from 1-10");
                Visitor.displayVInput(vis);
            }
        }
    }

    //Explore attractions, keeping in mind membership requirements and ticket purchases (if the attraction is OPEN)
    public static void visitAttraction(Visitor vis) {
        if (attractions.isEmpty()) {
            System.out.println("Sorry! There are no attractions at the moment.");
            return;
        }
        Scanner visAttraction = new Scanner(System.in);
        System.out.println("The attractions in the zoo are:- ");
        for (Attraction a : attractions) {
            System.out.println(a.getAttractionName());
        }
        System.out.print("Enter the name of the attraction you want to visit: ");
        String visAttractionName = visAttraction.nextLine();
        for (Attraction a : attractions) {
            if (Objects.equals(a.getAttractionName(), visAttractionName)) {
                if (!a.isOpen()) {
                    System.out.println("The attraction is closed at the moment, please visit again soon.");
                    return;
                }
                if (vis.getExperienceLevel() == 0) {
                    System.out.println("You have to first buy membership (using option 2) in order to visit the zoo");
                    return;
                }
                if (vis.getExperienceLevel() == 2) { // premium member allowed to visit any attraction
                    System.out.println("You are premium member!");
                    System.out.println("Welcome to attraction " + visAttractionName + "!");
                    System.out.println("Thank you for visiting " + visAttractionName + "! Hope you enjoyed the attraction.");
                    a.setVisitedTimes(a.getVisitedTimes() + 1);
                    vis.setHasVisited(true);
                    return;
                }
                if (vis.getExperienceLevel() == 1) {
                    if (vis.getAttractionTickets().isEmpty()) {
                        System.out.println("You have not purchased any tickets. Kindly buy tickets for attraction using option 3.");
                    } else {
                        for (String s : vis.getAttractionTickets()) {
                            if (Objects.equals(s, visAttractionName)) {
                                System.out.println("1 ticket of " + visAttractionName + " is used.");
                                vis.getAttractionTickets().remove(s);
                                System.out.println("Welcome to attraction " + visAttractionName + "!");
                                System.out.println("Thank you for visiting " + visAttractionName + "! Hope you enjoyed the attraction.");
                                a.setVisitedTimes(a.getVisitedTimes() + 1);
                                vis.setHasVisited(true);
                                return;
                            }
                        }
                        System.out.println("Sorry! Ticket for " + visAttractionName + " not available. You can buy tickets for attraction using option 3.");
                    }
                    return;
                }
            }
        }
        System.out.println("There is no attraction with this name, kindly check again & enter.");
    }

    //Interact with animals. Choose to feed an animal or read more about it
    public static void visitAnimal(Visitor vis) {
        if (vis.getExperienceLevel() == 0) {
            System.out.println("You have to first buy membership (using option 2) in order to visit the zoo");
            return;
        }
        Scanner visAnimal = new Scanner(System.in);
        System.out.println("The animals in the zoo are:- ");
        for (Animal a : animals) {
            System.out.println(a.getAnimalName());
        }
        System.out.print("Enter the name of the animal you want to visit: ");
        String visAnimalName = visAnimal.nextLine();
        for (Animal a : animals) {
            if (Objects.equals(a.getAnimalName(), visAnimalName)) {
                vis.setHasVisited(true);
                System.out.println("1. Feed the Animal");
                System.out.println("2. Read about the Animal");
                System.out.println("Enter your choice (1-2): ");
                int visAnimalC = visAnimal.nextInt();
                if (visAnimalC == 1) {
                    System.out.println("You have fed the " + a.getAnimalName());
                    a.makeNoise();
                    System.out.println("Thank you for feeding the " + a.getAnimalName());
                }
                if (visAnimalC == 2) {
                    a.displayDetails();
                }
                return;
            }
        }
        System.out.println("There is no such animal, kindly check again in the view animals option (Explore the Zoo)");
    }
}
