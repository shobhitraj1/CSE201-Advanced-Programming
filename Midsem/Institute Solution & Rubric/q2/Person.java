package midsem.q2;

public abstract class Person {
	
	private String firstName;
	private String lastName;
	private int id;
	private Address address;

	public Person(String firstName, String lastName, int id, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.id = id;
		this.address = address;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}

	public abstract void goToWork();	
	
}
