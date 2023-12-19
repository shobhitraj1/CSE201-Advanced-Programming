package org.IIITD;

// class Amphibian inherits Animal class & overrides methods for animals of type amphibian
public class Amphibian extends Animal {

    public Amphibian(String animalName, int animalID, String animalDetail, String animalSound) {
        super(animalName, animalID, animalDetail, animalSound);
        this.setAnimalType("Amphibian");
    }

    //Printing the details of animal of type Amphibian
    @Override
    public void displayDetails() {
        System.out.println("You are reading about " + this.getAnimalName() + " which is of type Amphibian :-");
        System.out.println(this.getAnimalDetail());
    }
}
