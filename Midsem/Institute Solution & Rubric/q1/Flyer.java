package midsem.q1;

public class Flyer implements RotateAndFly {

	@Override
	public void rotate() {
		System.out.println("Flyer rotates");		
	}

	@Override
	public void fly() {
		System.out.println("Flyer flies");		
	}
}
