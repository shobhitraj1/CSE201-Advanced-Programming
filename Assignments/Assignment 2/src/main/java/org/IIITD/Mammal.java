package org.IIITD;

// class Mammal inherits Animal class & overrides methods for animals of type mammal
public class Mammal extends Animal {

    public Mammal(String animalName, int animalID, String animalDetail, String animalSound) {
        super(animalName, animalID, animalDetail, animalSound);
        this.setAnimalType("Mammal");
    }

    //Printing the details of animal of type Mammal
    @Override
    public void displayDetails() {
        System.out.println("You are reading about " + this.getAnimalName() + " which is of type Mammal :-");
        System.out.println(this.getAnimalDetail());
    }
}
