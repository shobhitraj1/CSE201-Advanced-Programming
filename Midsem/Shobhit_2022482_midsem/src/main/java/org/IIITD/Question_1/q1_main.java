package org.IIITD.Question_1;

public class q1_main {
    public static void main(String[] args) {
        Helicopter chopper = new Helicopter();

        //argument type Rotator
        Rotatable rotater1 = new Rotator(); //runtime polymorphism (declared/referenced type is Rotatable but actual type is Rotator)
        chopper.drive(rotater1); // print type rotator - hence runtime polymorphism is demonstrated
        Rotator rotator2 = new Rotator();
        chopper.drive(rotator2); // print type rotator - demonstrates polymorphism as rotator implements Rotatable so all children of Rotatable can be passed as argument in drive method

        //argument type Flyer
        Rotatable flyer1 = new Flyer(); //runtime polymorphism (declared/referenced type is Rotatable but actual type is Flyer)
        chopper.drive(flyer1); //print type flyer - hence runtime polymorphism is demonstrated
        RotateAndFly flyer2 = new Flyer(); //runtime polymorphism (declared/referenced type is RotateAndFly but actual type is Flyer)
        chopper.drive(flyer2); //print type flyer - demonstrates polymorphism as rotateAndFly extends Rotatable so all children of Rotatable can be passed as argument in drive method
        Flyer flyer3 = new Flyer();
        chopper.drive(flyer3); //print type flyer

        //argument type Helicopter
        Rotatable heli1 = new Helicopter(); //runtime polymorphism (declared/referenced type is Rotatable but actual type is Helicopter)
        chopper.drive(heli1); //print type helicopter - hence runtime polymorphism is demonstrated
        RotateAndFly heli2 = new Helicopter(); //runtime polymorphism (declared/referenced type is RotateAndFly but actual type is Helicopter)
        chopper.drive(heli2); //print type helicopter - demonstrates polymorphism as rotateAndFly extends Rotatable so all children of Rotatable can be passed as argument in drive method
        Helicopter heli3 = new Helicopter();
        chopper.drive(heli3); //print type helicopter
    }
}
