package IIITD.Question_2;

import java.io.Serializable;

public class ComplexNumber implements Serializable {
    private double real;
    private double imaginary;

    public ComplexNumber(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal() {
        return real;
    }

    public void setReal(double real) {
        this.real = real;
    }

    public double getImaginary() {
        return imaginary;
    }

    public void setImaginary(double imaginary) {
        this.imaginary = imaginary;
    }

    public ComplexNumber conjugate() {
        double r = this.real;
        double i = -this.imaginary;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber add(ComplexNumber c) {
        double r = this.real + c.real;
        double i = this.imaginary + c.imaginary;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber subtract(ComplexNumber c) {
        double r = this.real - c.real;
        double i = this.imaginary - c.imaginary;
        return new ComplexNumber(r, i);
    }

    public ComplexNumber multiply(ComplexNumber c) {
        double r = (this.real * c.real) - (this.imaginary * c.imaginary);
        double i = (this.real * c.imaginary) + (this.imaginary * c.real);
        return new ComplexNumber(r, i);
    }

    public ComplexNumber divide(ComplexNumber c) { //using conjugate & multiply to divide
        ComplexNumber c1 = c.conjugate();
        ComplexNumber div = this.multiply(c1);
        double r = div.real / (c.real * c.real + c.imaginary * c.imaginary);
        double i = div.imaginary / (c.real * c.real + c.imaginary * c.imaginary);
        return new ComplexNumber(r, i);
    }

    @Override
    public String toString() {
        if (this.imaginary >= 0) return this.real + " + " + this.imaginary + "i";
        return this.real + " - " + -(this.imaginary) + "i";
    }
}
