package endsem.complex;

import java.io.Serializable;

public class ComplexNumber implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int real;
	private int imaginary;

	public ComplexNumber(int real, int imaginary) {
		this.real = real;
		this.imaginary = imaginary;
	}
	
	public int getReal() {
		return real;
	}

	public void setReal(int real) {
		this.real = real;
	}
	
	public int getImaginary() {
		return imaginary;
	}

	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	
	public ComplexNumber add(ComplexNumber c) {
		return new ComplexNumber(this.real + c.real, this.imaginary + c.imaginary);
	}
	
	public ComplexNumber subtract(ComplexNumber c) {
		return new ComplexNumber(this.real - c.real, this.imaginary - c.imaginary);
	}
	
	public ComplexNumber multiply(ComplexNumber c) {
		int r = (this.real * c.real) + (this.imaginary * c.imaginary * -1);
		int i = (this.real * c.imaginary) + (this.imaginary * c.real);
		return new ComplexNumber(r, i);
	}
	
	public ComplexNumber conjugate() {
		return new ComplexNumber(this.real, this.imaginary * -1);
	}
	
	public ComplexNumber divide(ComplexNumber c) {
		ComplexNumber conjDenom = c.conjugate();
		ComplexNumber complexNumDenominator = c.multiply(conjDenom);
		int denominator = (complexNumDenominator.real * complexNumDenominator.real) + 
				(complexNumDenominator.imaginary * complexNumDenominator.imaginary);
		int realNumerator = ((this.real * conjDenom.real) + 
				(this.imaginary * conjDenom.imaginary))/denominator;
		int imaginaryNumerator = ((this.imaginary * c.real) - 
				(this.real * c.imaginary))/denominator;
		return new ComplexNumber(realNumerator, imaginaryNumerator);
	}
	
	@Override
	public String toString() {
		return "(" + real + ", " + imaginary + ")";
	}
}
