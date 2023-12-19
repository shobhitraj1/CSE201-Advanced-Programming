package org.IIITD.Question_1;

public class Helicopter implements RotateAndFly {
    @Override
    public void rotate() {
        System.out.println("Helicopter rotates");
    }

    @Override
    public void fly() {
        System.out.println("Helicopter flies");
    }

    public void drive(Rotatable r) {
//        System.out.println("driving");
        System.out.println("Type name: " + r.getClass());
    }
}
