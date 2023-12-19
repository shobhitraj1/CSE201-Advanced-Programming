package midsem.q1;

public class Helicopter implements RotateAndFly {

	@Override
	public void rotate() {
		System.out.println("Helicoptor rotates");		
	}

	@Override
	public void fly() {
		System.out.println("Helicoptor flies");		
	}
	
	public void drive(Rotatable r) {
		r.rotate();
		System.out.println(r.getClass());
	}

	public static void main(String[] args) {
		Helicopter helicoptor = new Helicopter();
		helicoptor.drive(new Rotator());
		helicoptor.drive(new Flyer());
		helicoptor.drive(new Helicopter());
	}
}
