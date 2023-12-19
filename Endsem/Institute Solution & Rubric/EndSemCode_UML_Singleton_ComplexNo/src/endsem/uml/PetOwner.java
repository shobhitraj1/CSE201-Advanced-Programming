package endsem.uml;

import java.util.ArrayList;
import java.util.List;

public class PetOwner {
	
	private List<Dog> petDogList;	// Indicates 0..* multiplicity
	
	public PetOwner(List<Dog> petDogList) throws Exception {
		this.petDogList = petDogList;
		if(petDogList.isEmpty())	// This check is important to implement the 1..* multiplicity
			throw new Exception("A pet owner should have at least one pet");
	}
	
	public void groomAnimal(Dog dog) {
		System.out.println("Groom an animal -- " + dog.getName());
	}
	
	public void feedAllPets() {
		for(Dog d : petDogList)
			d.feedMe();
	}
	
	public static void main(String[] args) throws Exception {
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(new Dog(101, "D1"));
		dogList.add(new Dog(102, "D2"));
		PetOwner petOwner = new PetOwner(dogList);
		Dog dog = new Dog(101, "D1");
		dog.setDogOwner(petOwner);
		dog.feedMe();
		dog.takeForWalk();
		dog.groom();		
		petOwner.feedAllPets();
	}
}
