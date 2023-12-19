package org.IIITD.Question_2;

public abstract class Person {
    private String firstName;
    private String lastName;
    private int id;
    private Address addr;

    public abstract void goToWork();

    public Person() {
    }

    public Person(String firstName, String lastName, int id, Address addr) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.addr = addr;
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

    public Address getAddr() {
        return addr;
    }

    public void setAddr(Address addr) {
        this.addr = addr;
    }
}
