package org.IIITD;

// abstract class Animal serves as parent class & provides blueprint for any type of animal
public abstract class Animal implements Zoo {
    private String animalName;
    private String animalType;
    private int animalID;
    private int animalcount;
    private String animalDetail;
    private String animalSound;
    private static int noofanimals = 0;
    private static int noofMammals = 0;
    private static int noofAmphibian = 0;
    private static int noofReptile = 0;

    public Animal(String animalName, int animalID, String animalDetail, String animalSound) {
        this.animalName = animalName;
        this.animalID = animalID;
        this.animalDetail = animalDetail;
        this.animalSound = animalSound;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public int getAnimalID() {
        return animalID;
    }

    public void setAnimalID(int animalID) {
        this.animalID = animalID;
    }

    public int getAnimalcount() {
        return animalcount;
    }

    public void setAnimalcount(int animalcount) {
        this.animalcount = animalcount;
    }

    public String getAnimalDetail() {
        return animalDetail;
    }

    public void setAnimalDetail(String animalDetail) {
        this.animalDetail = animalDetail;
    }

    public String getAnimalSound() {
        return animalSound;
    }

    public void setAnimalSound(String animalSound) {
        this.animalSound = animalSound;
    }

    public static int getNoofanimals() {
        return noofanimals;
    }

    public static void setNoofanimals(int noofanimals) {
        Animal.noofanimals = noofanimals;
    }

    public static int getNoofMammals() {
        return noofMammals;
    }

    public static void setNoofMammals(int noofMammals) {
        Animal.noofMammals = noofMammals;
    }

    public static int getNoofAmphibian() {
        return noofAmphibian;
    }

    public static void setNoofAmphibian(int noofAmphibian) {
        Animal.noofAmphibian = noofAmphibian;
    }

    public static int getNoofReptile() {
        return noofReptile;
    }

    public static void setNoofReptile(int noofReptile) {
        Animal.noofReptile = noofReptile;
    }

    //custom string representation making it easier to display information about animals
    @Override
    public String toString() {
        return "Animal: " +
                "\nAnimal Name: " + animalName + "\nAnimal Type: " + animalType +
                "\nAnimal count: " + animalcount + "\nAnimal Detail: " + animalDetail;
    }

    //animal makes sound when fed
    public void makeNoise() {
        System.out.println(this.animalName + " is " + this.animalSound);
    }

    //Printing the details of any animal
    public void displayDetails() {
        System.out.println(animalDetail);
    }
}
