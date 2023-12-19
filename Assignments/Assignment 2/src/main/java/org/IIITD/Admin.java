package org.IIITD;

import java.util.Objects;
import java.util.Scanner;

// class Admin contains methods for functionalities of the Admin
public class Admin implements Zoo {
    private static int revenue = 0; //Revenue is the sum of tickets and memberships.

    public static int getRevenue() {
        return revenue;
    }

    public static void setRevenue(int revenue) {
        Admin.revenue = revenue;
    }

    //Add special deals that offer discounts based on the number of tickets purchased together
    public static void addDeal(int dealNo, int dealP) {
        for (Deal d : deals) {
            if (d.getCombinedTickets() == dealNo) {
                System.out.println("Deal with this number of tickets already exists! Kindly use option 2(or 3) to modify(or remove) deals");
                return;
            }
        }
        int dealID = Deal.getNoofdeals() + 1;
        Deal.setNoofdeals(dealID);
        Deal deal = new Deal(dealNo, dealP, dealID);
        deals.add(deal);
        System.out.println("Deal added successfully!");
        DealComp dealComp1 = new DealComp();
        deals.sort(dealComp1);
    }

    //Modify Deal's discount percentage
    public static void modifyDeal(int modifyDeal) {
        Scanner modifydeal = new Scanner(System.in);
        for (Deal d : deals) {
            if (d.getCombinedTickets() == modifyDeal) {
                System.out.println("You are modifying the deal with " + d.getCombinedTickets() + " no of combined tickets :-");
                System.out.print("Enter the new Special Discount Percentage (Between 0-100): ");
                d.setDealPercentage(modifydeal.nextInt());
                System.out.println("Deal modified successfully!");
                DealComp dealComp2 = new DealComp();
                deals.sort(dealComp2);
                return;
            }
        }
        System.out.println("There is no such deal! You can add/create deals using option 1.");
    }

    //Remove that particular special deal
    public static void removeDeal(int removeDeal) {
        for (Deal d : deals) {
            if (d.getCombinedTickets() == removeDeal) {
                deals.remove(d);
                System.out.println("Deal removed successfully!");
                return;
            }
        }
        System.out.println("There is no such deal! You can add/create deals using option 1.");
    }

    //Create/Add discount categories (e.g., Student, Senior) with a discount percentage and a unique discount code
    public static void addDiscount(String discountC, int discountP, String disCode) {
        for (Discount d : discounts) {
            if (Objects.equals(d.getDiscountCategory(), discountC)) {
                System.out.println("Discount with this category already exists! Kindly use option 2 to modify existing discounts.");
                return;
            }
        }
        int dID = Discount.getNoofdiscounts() + 1;
        Discount.setNoofdiscounts(dID);
        Discount d = new Discount(discountC, discountP, disCode, dID);
        discounts.add(d);
        System.out.println("Discount added successfully!");
    }

    //Modify discount's details
    public static void modifyDiscount(String modifydis) {
        Scanner modifydiscount = new Scanner(System.in);
        for (Discount d : discounts) {
            if (Objects.equals(d.getDiscountCategory(), modifydis)) {
                System.out.println("You are modifying the discount with category: " + d.getDiscountCategory());
                System.out.print("Enter the new Discount Percentage (Between 0-100): ");
                int modifyPer = modifydiscount.nextInt();
                modifydiscount.nextLine();
                System.out.print("Enter the new Discount CODE: ");
                String modifyCode = modifydiscount.nextLine();
                d.setDiscountPercentage(modifyPer);
                d.setDiscountCode(modifyCode);
                System.out.println("Discount modified successfully!");
                return;
            }
        }
        System.out.println("There is no discount with category: " + modifydis);
    }

    //Remove the particular discount
    public static void removedDiscount(String removedis) {
        for (Discount d : discounts) {
            if (Objects.equals(d.getDiscountCategory(), removedis)) {
                discounts.remove(d);
                System.out.println("Discount removed successfully!");
                return;
            }
        }
        System.out.println("There is no discount with category: " + removedis);
    }

    //Add new animals with details like species, description, and the sound they make
    public static void addAnimal(String animalN, String animalT, String animalD, String animalS) {
        if (!Objects.equals(animalT, "Mammal") && !Objects.equals(animalT, "Amphibian") && !Objects.equals(animalT, "Reptile")) {
            System.out.println("The animal should belong one of the 3 types : Mammal, Amphibian, Reptile");
            System.out.println("Kindly enter again!");
            return;
        }
        for (Animal a : animals) {
            if (Objects.equals(a.getAnimalName(), animalN)) {
                a.setAnimalcount(a.getAnimalcount() + 1);
                System.out.println("Animal already exists! Animal added successfully & count increased");
                return;
            }
        }
        int aniID = Animal.getNoofanimals() + 1;
        Animal.setNoofanimals(aniID);
        if (Objects.equals(animalT, "Mammal")) {
            Animal animal = new Mammal(animalN, aniID, animalD, animalS); //Runtime Polymorphism
            animal.setAnimalcount(animal.getAnimalcount() + 1);
            Animal.setNoofMammals(Animal.getNoofMammals() + 1);
            animals.add(animal);
        } else if (Objects.equals(animalT, "Amphibian")) {
            Animal animal = new Amphibian(animalN, aniID, animalD, animalS); //Runtime Polymorphism
            animal.setAnimalcount(animal.getAnimalcount() + 1);
            Animal.setNoofAmphibian(Animal.getNoofAmphibian() + 1);
            animals.add(animal);
        } else {
            Animal animal = new Reptile(animalN, aniID, animalD, animalS); //Runtime Polymorphism
            animal.setAnimalcount(animal.getAnimalcount() + 1);
            Animal.setNoofReptile(Animal.getNoofReptile() + 1);
            animals.add(animal);
        }
        System.out.println("Animal added successfully!");
    }

    //Modify animal's details
    public static void modifyAnimal(String modifyname) {
        Scanner modifyanimal = new Scanner(System.in);
        for (Animal a : animals) {
            if (Objects.equals(a.getAnimalName(), modifyname)) {
                System.out.println("You are modifying the " + a.getAnimalName());
                System.out.print("Enter the new details of the animal: ");
                a.setAnimalDetail(modifyanimal.nextLine());
                System.out.println("Animal's details updated successfully!");
                return;
            }
        }
        System.out.println("There is no animal in the zoo with the name: " + modifyname);
    }

    //Remove the particular animal from the zoo while ensuring the zoo has minimum 2 animals of each type
    public static void removeAnimal(String removename) {
        for (Animal a : animals) {
            if (Objects.equals(a.getAnimalName(), removename)) {
                if (Objects.equals(a.getAnimalType(), "Mammal") && Animal.getNoofMammals() <= 2) {
                    System.out.println("Sorry, you can't remove this animal. There should be minimum 2 animals of Mammal type for visitors to view/visit.");
                    System.out.println("Kindly add more mammals & then remove this animal.");
                    return;
                }
                if (Objects.equals(a.getAnimalType(), "Amphibian") && Animal.getNoofAmphibian() <= 2) {
                    System.out.println("Sorry, you can't remove this animal. There should be minimum 2 animals of Amphibian type for visitors to view/visit.");
                    System.out.println("Kindly add more amphibians & then remove this animal.");
                    return;
                }
                if (Objects.equals(a.getAnimalType(), "Reptile") && Animal.getNoofReptile() <= 2) {
                    System.out.println("Sorry, you can't remove this animal. There should be minimum 2 animals of Reptile type for visitors to view/visit.");
                    System.out.println("Kindly add more reptiles & then remove this animal.");
                    return;
                }
                animals.remove(a);
                if (Objects.equals(a.getAnimalType(), "Mammal")) Animal.setNoofMammals(Animal.getNoofMammals() - 1);
                if (Objects.equals(a.getAnimalType(), "Amphibian"))
                    Animal.setNoofAmphibian(Animal.getNoofAmphibian() - 1);
                if (Objects.equals(a.getAnimalType(), "Reptile")) Animal.setNoofReptile(Animal.getNoofReptile() - 1);
                System.out.println("Animal removed successfully!");
                return;
            }
        }
        System.out.println("There is no animal in the zoo with the name: " + removename);
    }

    //Add new attractions with descriptions and ticket prices
    public static void addAttraction(String attractionN, String attractionD, int attractionP) {
        for (Attraction a : attractions) {
            if (Objects.equals(a.getAttractionName(), attractionN)) {
                System.out.println("Attraction already exists!");
                return;
            }
        }
        int aID = Attraction.getNoofattractions() + 1;
        Attraction.setNoofattractions(aID);
        Attraction a = new Attraction(attractionN, attractionD, aID, attractionP);
        attractions.add(a);
        System.out.println("Attraction added successfully!");
    }

    //Remove an attraction from the zoo
    public static void removeAttraction(String removeN) {
        for (Attraction a : attractions) {
            if (Objects.equals(a.getAttractionName(), removeN)) {
                attractions.remove(a);
                System.out.println("Attraction removed successfully!");
                return;
            }
        }
        System.out.println("There is no attraction with name: " + removeN);
    }

    //Modify existing attraction's details
    public static void modifyAttraction(String modifyN) {
        Scanner modifyattractions = new Scanner(System.in);
        for (Attraction a : attractions) {
            if (Objects.equals(a.getAttractionName(), modifyN)) {
                System.out.println("You are modifying the " + a.getAttractionName() + " attraction :-");
                System.out.print("Enter the new Attraction description: ");
                String modifyD = modifyattractions.nextLine();
                System.out.print("Enter the new price of ticket of the attraction: ");
                int modifyP = modifyattractions.nextInt();
                a.setAttractionDesc(modifyD);
                a.setTicketPrice(modifyP);
                System.out.println("Attraction modified successfully!");
                return;
            }
        }
        System.out.println("There is no attraction with name: " + modifyN);
    }

    //Taking the name of the attraction admin wants to schedule
    public static void scheduleAttractions() {
        Scanner schedule = new Scanner(System.in);
        System.out.println("The attractions in the zoo are :- ");
        for (Attraction a : attractions) {
            System.out.println(a.getAttractionName());
        }
        System.out.print("Enter the name of the attraction you want to schedule: ");
        String scheduleN = schedule.nextLine();
        scheduleAttraction(scheduleN);
    }

    //Specify the opening status of the attraction along with ticket price
    public static void scheduleAttraction(String scheduleN) {
        Scanner schedule1 = new Scanner(System.in);
        for (Attraction a : attractions) {
            if (Objects.equals(a.getAttractionName(), scheduleN)) {
                System.out.print("Enter OPEN or CLOSE to schedule the attraction: ");
                String status = schedule1.nextLine();
                System.out.print("Enter the new price of ticket of the attraction: ");
                int price = schedule1.nextInt();
                a.setOpen(!Objects.equals(status, "CLOSE"));
                a.setTicketPrice(price);
                System.out.println("The attraction has been scheduled accordingly & price of the ticket has been selected!");
                return;
            }
        }
        System.out.println("There is no attraction with name: " + scheduleN);
    }

    //Displays the Admin Mode Menu (Options for functionalities as Admin)
    public static void displayAInput() {
        System.out.println("------------------------------");
        System.out.println("You have entered as Admin. Select what you want to do:-");
        System.out.println("1. Manage Attractions");
        System.out.println("2. Manage Animals");
        System.out.println("3. Schedule Events");
        System.out.println("4. Set Discounts");
        System.out.println("5. Set Special Deal");
        System.out.println("6. View Visitor Stats");
        System.out.println("7. View Feedback");
        System.out.println("8. Exit");
        System.out.print("Enter the option (1-8): ");
        Scanner s = new Scanner(System.in);
        int AInput = s.nextInt();
        switch (AInput) {
            case 1 -> Admin.manageAttractions();
            case 2 -> Admin.manageAnimals();
            case 3 -> {
                Admin.scheduleAttractions();
                Admin.displayAInput();
            }
            case 4 -> Admin.manageDiscounts();
            case 5 -> Admin.manageDeals();
            case 6 -> {
                System.out.println();
                System.out.println("Visitor Statistics:- ");
                System.out.println("1. Total Visitors:- ");
                System.out.println("The total no of visitors who have registered in the zoo : " + Visitor.getNoofvisitors());
                int nVis = 0;
                for (Visitor v : visitors) {
                    if (v.isHasVisited()) nVis++;
                }
                System.out.println("The total no of visitors who have visited animal/attraction in the zoo : " + nVis);
                System.out.println();
                System.out.println("2. Total Revenue: $" + revenue);
                System.out.println();
                System.out.println("3. Most Popular Attraction:- ");
                AttractionMostTicket aMostTicketSold = new AttractionMostTicket();
                attractions.sort(aMostTicketSold);
                System.out.println(attractions.get(0).getAttractionName() + " is the attraction with most tickets sold!");
                AttractionMostVisited aMostVisited = new AttractionMostVisited();
                attractions.sort(aMostVisited);
                System.out.println(attractions.get(0).getAttractionName() + " is the attraction which is most visited by visitors!");
                Admin.displayAInput();
            }
            case 7 -> {
                if (feedback.isEmpty()) {
                    System.out.println("There are no feedbacks at the moment!");
                } else {
                    System.out.println("The feedbacks are:- ");
                    for (String f : feedback) {
                        System.out.println(f);
                    }
                }
                Admin.displayAInput();
            }
            case 8 -> {
                System.out.println("Logged out!");
                Main.takeInput();
            }
            default -> {
                System.out.println("Choose and enter valid option from 1-8");
                Admin.displayAInput();
            }
        }
    }

    //Admin can add, modify, remove or view special deals of the zoo
    public static void manageDeals() {
        System.out.println("------------------------------");
        System.out.println("Manage Deals : ");
        System.out.println("1. Add Deal");
        System.out.println("2. Modify Deal");
        System.out.println("3. Remove Deal");
        System.out.println("4. View Deals");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
        Scanner managedeals = new Scanner(System.in);
        int manage4 = managedeals.nextInt();
        switch (manage4) {
            case 1 -> {
                System.out.print("Enter Number of tickets on which deal is valid: ");
                int dealNo = managedeals.nextInt();
                System.out.print("Enter Special Discount Percentage (Between 0-100): ");
                int dealP = managedeals.nextInt();
                addDeal(dealNo, dealP);
                Admin.manageDeals();
            }
            case 2 -> {
                System.out.print("Enter the no of tickets (combined) of the deal you want to modify: ");
                int modifyDeal = managedeals.nextInt();
                modifyDeal(modifyDeal);
                Admin.manageDeals();
            }
            case 3 -> {
                System.out.print("Enter the no of tickets (combined) of the deal you want to remove: ");
                int removeDeal = managedeals.nextInt();
                removeDeal(removeDeal);
                Admin.manageDeals();
            }
            case 4 -> {
                if (deals.isEmpty()) {
                    System.out.println("There are no deals at the moment. You can add using option 1.");
                } else {
                    System.out.println("The deals are :-");
                    for (Deal d : deals) {
                        System.out.println(d);
                    }
                }
                Admin.manageDeals();
            }
            case 5 -> Admin.displayAInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-5");
                Admin.manageDeals();
            }
        }
    }

    //Admin can add, modify, remove or view discounts of the zoo
    public static void manageDiscounts() {
        System.out.println("------------------------------");
        System.out.println("Manage Discounts : ");
        System.out.println("1. Add Discount");
        System.out.println("2. Modify Discount");
        System.out.println("3. Remove Discount");
        System.out.println("4. View Discounts");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
        Scanner managediscounts = new Scanner(System.in);
        int manage3 = managediscounts.nextInt();
        switch (manage3) {
            case 1 -> {
                managediscounts.nextLine();
                System.out.print("Enter Discount Category: ");
                String discountC = managediscounts.nextLine();
                System.out.print("Enter Discount Percentage (Between 0-100): ");
                int discountP = managediscounts.nextInt();
                managediscounts.nextLine();
                System.out.print("Enter Discount CODE: ");
                String disCode = managediscounts.nextLine();
                addDiscount(discountC, discountP, disCode);
                Admin.manageDiscounts();
            }
            case 2 -> {
                managediscounts.nextLine();
                System.out.print("Enter the category of the discount you want to modify: ");
                String modifydis = managediscounts.nextLine();
                modifyDiscount(modifydis);
                Admin.manageDiscounts();
            }
            case 3 -> {
                managediscounts.nextLine();
                System.out.print("Enter the category of the discount you want to remove: ");
                String removedis = managediscounts.nextLine();
                removedDiscount(removedis);
                Admin.manageDiscounts();
            }
            case 4 -> {
                if (discounts.isEmpty()) {
                    System.out.println("There are no discounts at the moment. You can add using option 1.");
                } else {
                    System.out.println("The discounts are :-");
                    for (Discount d : discounts) {
                        System.out.println(d);
                    }
                }
                Admin.manageDiscounts();
            }
            case 5 -> Admin.displayAInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-5");
                Admin.manageDiscounts();
            }
        }
    }

    //Admin can add, modify, remove or view animals of the zoo
    public static void manageAnimals() {
        System.out.println("------------------------------");
        System.out.println("Manage Animals : ");
        System.out.println("1. Add Animal");
        System.out.println("2. View Animals");
        System.out.println("3. Update Animal Details");
        System.out.println("4. Remove Animal");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
        Scanner manageanimals = new Scanner(System.in);
        int manage2 = manageanimals.nextInt();
        switch (manage2) {
            case 1 -> {
                manageanimals.nextLine();
                System.out.print("Enter Animal name: ");
                String animalN = manageanimals.nextLine();
                System.out.print("Enter Animal type (Mammal/Amphibian/Reptile): ");
                String animalT = manageanimals.nextLine();
                System.out.print("Enter Animal Details: ");
                String animalD = manageanimals.nextLine();
                System.out.print("Enter Animal Sound: ");
                String animalS = manageanimals.nextLine();
                addAnimal(animalN, animalT, animalD, animalS);
                Admin.manageAnimals();
            }
            case 2 -> {
                System.out.println("The animals in the zoo are:- ");
                for (Animal a : animals) {
                    System.out.println(a);
                }
                Admin.manageAnimals();
            }
            case 3 -> {
                manageanimals.nextLine();
                System.out.print("Enter the name of the animal you want to update: ");
                String modifyname = manageanimals.nextLine();
                modifyAnimal(modifyname);
                Admin.manageAnimals();
            }
            case 4 -> {
                manageanimals.nextLine();
                System.out.print("Enter the name of the animal you want to remove: ");
                String removename = manageanimals.nextLine();
                removeAnimal(removename);
                Admin.manageAnimals();
            }
            case 5 -> Admin.displayAInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-5");
                Admin.manageAnimals();
            }
        }
    }

    //Admin can add, modify, remove or view attractions of the zoo
    public static void manageAttractions() {
        System.out.println("------------------------------");
        System.out.println("Manage Attractions : ");
        System.out.println("1. Add Attraction");
        System.out.println("2. View Attractions");
        System.out.println("3. Modify Attraction");
        System.out.println("4. Remove Attraction");
        System.out.println("5. Exit");
        System.out.print("Enter your choice (1-5): ");
        Scanner manageattractions = new Scanner(System.in);
        int manage1 = manageattractions.nextInt();
        switch (manage1) {
            case 1 -> {
                manageattractions.nextLine();
                System.out.print("Enter Attraction name: ");
                String attractionN = manageattractions.nextLine();
                System.out.print("Enter Attraction description: ");
                String attractionD = manageattractions.nextLine();
                System.out.print("Enter the price of ticket of the attraction: ");
                int attractionP = manageattractions.nextInt();
                addAttraction(attractionN, attractionD, attractionP);
                Admin.manageAttractions();
            }
            case 2 -> {
                if (attractions.isEmpty()) {
                    System.out.println("There are no attractions at the moment. You can add using option 1.");
                } else {
                    System.out.println("The attractions in the zoo are:- ");
                    for (Attraction a : attractions) {
                        System.out.println(a);
                    }
                }
                Admin.manageAttractions();
            }
            case 3 -> {
                manageattractions.nextLine();
                System.out.print("Enter the name of the attraction you want to modify: ");
                String modifyN = manageattractions.nextLine();
                modifyAttraction(modifyN);
                Admin.manageAttractions();
            }
            case 4 -> {
                manageattractions.nextLine();
                System.out.print("Enter the name of the attraction you want to remove: ");
                String removeN = manageattractions.nextLine();
                removeAttraction(removeN);
                Admin.manageAttractions();
            }
            case 5 -> Admin.displayAInput();
            default -> {
                System.out.println("Choose and enter valid option from 1-5");
                Admin.manageAttractions();
            }
        }
    }
}
