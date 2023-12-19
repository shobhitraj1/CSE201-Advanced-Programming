package org.IIITD;

// class Reptile inherits Animal class & overrides methods for animals of type reptile
public class Reptile extends Animal {

    public Reptile(String animalName, int animalID, String animalDetail, String animalSound) {
        super(animalName, animalID, animalDetail, animalSound);
        this.setAnimalType("Reptile");
    }

    //Printing the details of animal of type Reptile
    @Override
    public void displayDetails() {
        System.out.println("You are reading about " + this.getAnimalName() + " which is of type Reptile :-");
        System.out.println(this.getAnimalDetail());
    }
}
