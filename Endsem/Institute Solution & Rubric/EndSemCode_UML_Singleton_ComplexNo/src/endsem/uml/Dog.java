package endsem.uml;

public class Dog extends Mammal {
	
	private PetOwner dogOwner;		// A Dog has only one Owner
	
	public Dog(int id, String name) throws Exception {
		super(id, name);
	}
	
	public void setDogOwner(PetOwner petOwner) {
		this.dogOwner = petOwner;
	}

	public void takeForWalk() {
		System.out.println("Take for a walk");
	}
	
	public void groom() {
		dogOwner.groomAnimal(this);
	}
}
