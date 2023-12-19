package com.IIITD_AP_KR22;
import java.util.*;

public class q3e<T> {
    T a,b;

    q3e (T a,T b){
        this.a=a;
        this.b=b;
    }

    public String add(){

        return a.toString()+b.toString();
        //return String.valueOf(a)+String.valueOf(b);
        //both return statements work
    }

}


class MMain{
    public static void main(String[] args) {
        q3e<Integer>ab =new q3e<Integer>(1,3);
        System.out.println(ab.add());

        q3e<String>ac =new q3e<String>("AP","2023");
        System.out.println(ac.add());
    }
}