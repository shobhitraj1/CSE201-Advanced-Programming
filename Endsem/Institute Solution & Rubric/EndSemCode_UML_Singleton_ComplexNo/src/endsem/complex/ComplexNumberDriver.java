package endsem.complex;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComplexNumberDriver {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Random random = new Random();
		List<ComplexNumber> lst1 = new ArrayList<ComplexNumber>();
		for(int i=0; i<10; i++) {
			lst1.add(new ComplexNumber(random.nextInt(100), random.nextInt(100)));
		}
		
		List<ComplexNumber> lst2 = new ArrayList<ComplexNumber>();
		for(int i=0; i<10; i++) {
			lst2.add(new ComplexNumber(random.nextInt(100), random.nextInt(100)));
		}
		
		List<ComplexNumber> additionLst = new ArrayList<ComplexNumber>();
		List<ComplexNumber> subtractionLst = new ArrayList<ComplexNumber>();
		List<ComplexNumber> multiplicationLst = new ArrayList<ComplexNumber>();
		List<ComplexNumber> divisionLst = new ArrayList<ComplexNumber>();
		
		for(int i=0; i<lst1.size(); i++) {
			additionLst.add(lst1.get(i).add(lst2.get(i)));
			subtractionLst.add(lst1.get(i).subtract(lst2.get(i)));
			multiplicationLst.add(lst1.get(i).multiply(lst2.get(i)));
			divisionLst.add(lst1.get(i).divide(lst2.get(i)));
		}
		
		ObjectOutputStream addFile = null;
		ObjectOutputStream subtractFile = null;
		ObjectOutputStream multiplyFile = null;
		ObjectOutputStream divisionFile = null;
		try {
			addFile = new ObjectOutputStream(new FileOutputStream("add.bin"));
			for(ComplexNumber c : additionLst) 
				addFile.writeObject(c);
			
			subtractFile = new ObjectOutputStream(new FileOutputStream("subtract.bin"));
			for(ComplexNumber c : subtractionLst) 
				subtractFile.writeObject(c);
			
			multiplyFile = new ObjectOutputStream(new FileOutputStream("multiply.bin"));
			for(ComplexNumber c : multiplicationLst)
				multiplyFile.writeObject(c);
			
			divisionFile = new ObjectOutputStream(new FileOutputStream("division.bin"));
			for(ComplexNumber c : divisionLst)
				divisionFile.writeObject(c);
		} finally {
			if(addFile != null)
				addFile.close();
			if(subtractFile != null)
				subtractFile.close();
			if(multiplyFile != null)
				multiplyFile.close();
			if(divisionFile != null)
				divisionFile.close();
		}
		System.out.println("Done");
	}
}
