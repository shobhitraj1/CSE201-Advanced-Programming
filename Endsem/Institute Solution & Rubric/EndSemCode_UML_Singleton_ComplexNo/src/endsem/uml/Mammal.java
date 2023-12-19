package endsem.uml;

public class Mammal extends Animal {

	public Mammal (int id, String name) {
		super(id, name);
	}
	
	@Override
	public void feedMe() {
		System.out.println("Feed me something");
	}
}
