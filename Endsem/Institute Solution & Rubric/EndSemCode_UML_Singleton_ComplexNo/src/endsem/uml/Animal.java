package endsem.uml;

public abstract class Animal {
	
	private int id;
	private String name;

	public Animal(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public int getID() {
		return id;
	}
	public void setID(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public abstract void feedMe();

}
