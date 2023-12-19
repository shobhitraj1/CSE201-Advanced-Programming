package IIITD.Question_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Main_q2 {
    public static void AddSets(ArrayList<ComplexNumber> A, ArrayList<ComplexNumber> B) throws IOException {
        ArrayList<ComplexNumber> sum = new ArrayList<>(10);
        FileWriter out = null;
        try{
            out = new FileWriter("outAdd.txt");
            for (int i=0;i<10;i++){
                ComplexNumber c = A.get(i).add(B.get(i));
                sum.add(c);
                out.write(c.toString()); //saving the results in readable form in file
                out.write("\n");
            }
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out!=null){
                out.close();
            }
        }
        System.out.println("Addition results added successfully");
        //adding resultant set as object into file
        ObjectOutputStream out1 = null;
        try{
            out1 = new ObjectOutputStream(new FileOutputStream("outAddObject.txt"));
            out1.writeObject(sum.toString()); //saving the entire set as object in file  i.e. serializing
//            out1.writeObject(sum); //unreadable form
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out1!=null){
                out1.close();
            }
        }
        System.out.println("Addition result set object added successfully");
    }
    public static void SubtractSets(ArrayList<ComplexNumber> A, ArrayList<ComplexNumber> B) throws IOException {
        ArrayList<ComplexNumber> difference = new ArrayList<>(10);
        FileWriter out = null;
        try{
            out = new FileWriter("outSubtract.txt");
            for (int i=0;i<10;i++){
                ComplexNumber c = A.get(i).subtract(B.get(i));
                difference.add(c);
                out.write(c.toString());
                out.write("\n");
            }
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out!=null){
                out.close();
            }
        }
        System.out.println("Subtraction results added successfully");
        //adding resultant set as object into file
        ObjectOutputStream out1 = null;
        try{
            out1 = new ObjectOutputStream(new FileOutputStream("outSubtractObject.txt"));
            out1.writeObject(difference.toString()); //saving the entire set as object in file  i.e. serializing
//            out1.writeObject(difference); //unreadable form
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out1!=null){
                out1.close();
            }
        }
        System.out.println("Subtraction result set object added successfully");
    }
    public static void MultiplySets(ArrayList<ComplexNumber> A, ArrayList<ComplexNumber> B) throws IOException {
        ArrayList<ComplexNumber> product = new ArrayList<>(10);
        FileWriter out = null;
        try{
            out = new FileWriter("outMultiply.txt");
            for (int i=0;i<10;i++){
                ComplexNumber c = A.get(i).multiply(B.get(i));
                product.add(c);
                out.write(c.toString());
                out.write("\n");
            }
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out!=null){
                out.close();
            }
        }
        System.out.println("Multiplication results added successfully");
        //adding resultant set as object into file
        ObjectOutputStream out1 = null;
        try{
            out1 = new ObjectOutputStream(new FileOutputStream("outMultiplyObject.txt"));
            out1.writeObject(product.toString()); //saving the entire set as object in file  i.e. serializing
//            out1.writeObject(product); //unreadable form
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out1!=null){
                out1.close();
            }
        }
        System.out.println("Multiplication result set object added successfully");
    }
    public static void DivideSets(ArrayList<ComplexNumber> A, ArrayList<ComplexNumber> B) throws IOException {
        ArrayList<ComplexNumber> div = new ArrayList<>(10);
        FileWriter out = null;
        try{
            out = new FileWriter("outDivide.txt");
            for (int i=0;i<10;i++){
                ComplexNumber c = A.get(i).divide(B.get(i));
                div.add(c);
                out.write(c.toString());
                out.write("\n");
            }
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out!=null){
                out.close();
            }
        }
        System.out.println("Division results added successfully");
        //adding resultant set as object into file
        ObjectOutputStream out1 = null;
        try{
            out1 = new ObjectOutputStream(new FileOutputStream("outDivisionObject.txt"));
            out1.writeObject(div.toString()); //saving the entire set as object in file i.e. serializing
//            out1.writeObject(div); //unreadable form
        }catch (IOException e){
            System.out.println("Error in opening/writing in file");
        }
        finally {
            if (out1!=null){
                out1.close();
            }
        }
        System.out.println("Division result set object added successfully");
    }
    public static void main(String[] args) throws IOException {
        ArrayList<ComplexNumber> A = new ArrayList<>(10);
        ArrayList<ComplexNumber> B = new ArrayList<>(10);
        Random r = new Random();
        ComplexNumber a1 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a2 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a3 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a4 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a5 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a6 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a7 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a8 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a9 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber a10 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b1 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b2 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b3 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b4 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b5 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b6 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b7 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b8 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b9 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        ComplexNumber b10 = new ComplexNumber(r.nextDouble(10), r.nextDouble(10));
        A.add(a1);
        A.add(a2);
        A.add(a3);
        A.add(a4);
        A.add(a5);
        A.add(a6);
        A.add(a7);
        A.add(a8);
        A.add(a9);
        A.add(a10);
        B.add(b1);
        B.add(b2);
        B.add(b3);
        B.add(b4);
        B.add(b5);
        B.add(b6);
        B.add(b7);
        B.add(b8);
        B.add(b9);
        B.add(b10);
        System.out.println("Elements in A");
        for (ComplexNumber c : A){
            System.out.println(c.toString());
        }
        System.out.println("Elements in B");
        for (ComplexNumber c : B){
            System.out.println(c.toString());
        }
        AddSets(A,B);
        SubtractSets(A,B);
        MultiplySets(A,B);
        DivideSets(A,B);

    }

}
